package org.example.smartcontacts.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.smartcontacts.entity.AppSetting;
import org.example.smartcontacts.repository.AppSettingRepository;
import org.example.smartcontacts.service.AppSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppSettingServiceImpl implements AppSettingService {

    private final AppSettingRepository appSettingRepository;

    @Override
    public List<AppSetting> getAllAppSettings() {
        return appSettingRepository.findAll();
    }

    @Override
    public AppSetting getAppSettingById(long appSettingId) {
        return appSettingRepository.findById(appSettingId).orElse(null);
    }

    @Override
    public void addAppSetting(AppSetting appSetting) {
        // Kiểm tra tính hợp lệ của thông tin cài đặt và xử lý logic thêm mới
        if (isValidAppSetting(appSetting)) {
            appSettingRepository.save(appSetting);
        } else {
            throw new IllegalArgumentException("Thông tin cài đặt ứng dụng không hợp lệ");
        }
    }

    @Override
    public void updateAppSetting(AppSetting appSetting) {
        // Kiểm tra tính hợp lệ của thông tin cập nhật và xử lý logic cập nhật
        if (isValidAppSetting(appSetting)) {
            appSettingRepository.save(appSetting);
        } else {
            throw new IllegalArgumentException("Thông tin cài đặt ứng dụng không hợp lệ");
        }
    }

    @Override
    public void deleteAppSetting(long appSettingId) {
        appSettingRepository.deleteById(appSettingId);
    }

    // Các phương thức hỗ trợ kiểm tra tính hợp lệ
    private boolean isValidAppSetting(AppSetting appSetting) {
        return true;
        // Thực hiện các kiểm tra nhất định, ví dụ: kiểm tra không null, không rỗng, ...
        // return appSetting != null && appSetting.getSettingName() != null && !appSetting.getSettingName().isEmpty();
    }
}

