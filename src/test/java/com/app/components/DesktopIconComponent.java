package com.app.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.utils.AnimationHandler;

public class DesktopIconComponent {
    private WebDriver driver;
    private WebDriverWait wait;
    private String iconName;

    public DesktopIconComponent(WebDriver driver, WebDriverWait wait, String iconName) {
        this.driver = driver;
        this.wait = wait;
        this.iconName = iconName;
    }

    public void click() {
        String iconXpath = "//div[@data-typename='DesktopIcon']//div[text()='" + iconName + "']/..";
        By iconLocator = By.xpath(iconXpath);
        driver.findElement(iconLocator).click();
        AnimationHandler.waitForAnimationToComplete();
    }

}
