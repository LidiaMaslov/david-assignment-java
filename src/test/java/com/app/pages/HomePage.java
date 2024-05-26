package com.app.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.components.DesktopIconComponent;

public class HomePage extends BasePage {
    private By desktopContainer = By.id("Desktop");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void pageLoaded() {
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        longWait.until(ExpectedConditions.visibilityOfElementLocated(desktopContainer));
    }

    public DesktopIconComponent desktopIcon(String name) {
        DesktopIconComponent desktopIconComponent = new DesktopIconComponent(driver, wait, name);
        return desktopIconComponent;
    }
}
