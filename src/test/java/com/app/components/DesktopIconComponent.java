package com.app.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.app.utils.AnimationHandler;

public class DesktopIconComponent {
    private WebDriver driver;
    private String iconName;

    public DesktopIconComponent(WebDriver driver, String iconName) {
        this.driver = driver;
        this.iconName = iconName;
    }

    public void click() {
        String iconXpath = "//div[@data-typename='DesktopIcon']//div[text()='" + iconName + "']/..";
        By iconLocator = By.xpath(iconXpath);
        driver.findElement(iconLocator).click();
        AnimationHandler.waitForAnimationToComplete();
    }

}
