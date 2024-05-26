package com.app.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubMenuFinder extends BaseMenuFinder {
    public SubMenuFinder(WebDriver driver) {
        super(driver);
    }

    public WebElement findByName(String name) {
        return findByNameAndType(name, "SettingsItem");
    }
}
