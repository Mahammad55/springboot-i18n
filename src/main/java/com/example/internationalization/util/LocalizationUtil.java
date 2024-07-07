package com.example.internationalization.util;

import lombok.experimental.UtilityClass;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.ResourceBundle;

@UtilityClass
public class LocalizationUtil {

    public static String getLocalizedMessageByStatusCode(String bundleName, Integer statusCode) {
        var resourceBundle = ResourceBundle.getBundle(bundleName, LocaleContextHolder.getLocale());
        return resourceBundle.getString(getMessageKeyByStatusCode(statusCode));
    }

    public static String getLocalizedMessageByKey(String bundleName, String key) {
        var locale = LocaleContextHolder.getLocale();
        return ResourceBundle.getBundle(bundleName, locale).getString(key);
    }

    private static String getMessageKeyByStatusCode(Integer statusCode) {
        return switch (statusCode) {
            case 404 -> "user.not.found.exception";
            case 409 -> "user.already.exist.exception";
            default -> "unexpected.exception";
        };
    }
}
