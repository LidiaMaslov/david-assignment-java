package com.app.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainMenuFinder extends BaseMenuFinder {
    public MainMenuFinder(WebDriver driver) {
        super(driver);
    }

    public WebElement findByName(String name) {
        return findByNameAndType(name, "SettingsItemMainMenu");
    }
}
