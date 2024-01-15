package org.example.smartcontacts.controller;

import lombok.RequiredArgsConstructor;
import org.example.smartcontacts.entity.AppSetting;
import org.example.smartcontacts.service.AppSettingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appsettings")
@RequiredArgsConstructor
public class AppSettingController {

    private final AppSettingService appSettingService;

    @GetMapping("/all")
    public ResponseEntity<List<AppSetting>> getAllAppSettings() {
        List<AppSetting> appSettings = appSettingService.getAllAppSettings();
        return new ResponseEntity<>(appSettings, HttpStatus.OK);
    }

    @GetMapping("/{appSettingId}")
    public ResponseEntity<AppSetting> getAppSettingById(@PathVariable long appSettingId) {
        AppSetting appSetting = appSettingService.getAppSettingById(appSettingId);
        if (appSetting != null) {
            return new ResponseEntity<>(appSetting, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAppSetting(@RequestBody AppSetting appSetting) {
        try {
            appSettingService.addAppSetting(appSetting);
            return new ResponseEntity<>("AppSetting added successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateAppSetting(@RequestBody AppSetting appSetting) {
        try {
            appSettingService.updateAppSetting(appSetting);
            return new ResponseEntity<>("AppSetting updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{appSettingId}")
    public ResponseEntity<String> deleteAppSetting(@PathVariable long appSettingId) {
        appSettingService.deleteAppSetting(appSettingId);
        return new ResponseEntity<>("AppSetting deleted successfully", HttpStatus.OK);
    }
}
