package org.example.smartcontacts.service;
import org.example.smartcontacts.entity.AppSetting;

import java.util.List;

public interface AppSettingService {

    List<AppSetting> getAllAppSettings();

    AppSetting getAppSettingById(long appSettingId);

    void addAppSetting(AppSetting appSetting);

    void updateAppSetting(AppSetting appSetting);

    void deleteAppSetting(long appSettingId);

    // Các phương thức tùy chỉnh khác nếu cần
}

