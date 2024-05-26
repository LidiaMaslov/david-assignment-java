package com.app.navigation;

import com.app.pages.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigate {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    public Navigate() {
        this.driver = Browser.start();
        this.baseUrl = System.getenv("SELENIUM_BASE_URL");
        if (this.baseUrl == null || this.baseUrl.trim().isEmpty()) {
            this.baseUrl = "https://testoutlivecontent.blob.core.windows.net";
        }
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }

    public void homePage(HomePageCallback callback) {
        goTo("/netpro2018v5-en-us/en-us/sims/typescriptv1/netpro2018v5/simstartup_webpack.html?package=netpro2018v5windowspackage&sim=ipademail_np5&dev=true&automation=true");
        HomePage homePage = new HomePage(this.driver, this.wait);
        homePage.pageLoaded();
        callback.execute(homePage);
    }

    public void settingsPage(SettingsPageCallback callback) {
        SettingsPage settingsPage = new SettingsPage(this.driver, this.wait);
        settingsPage.pageLoaded();
        callback.execute(settingsPage);
    }

    public void labPage(LabPageCallback callback) {
        LabPage labPage = new LabPage(this.driver, this.wait);
        labPage.pageLoaded();
        callback.execute(labPage);
    }

    public void goTo(String path) {
        driver.get(baseUrl + (path.startsWith("/") ? path : "/" + path));
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public interface HomePageCallback {
        void execute(HomePage homePage);
    }

    public interface SettingsPageCallback {
        void execute(SettingsPage settingsPage);
    }

    public interface LabPageCallback {
        void execute(LabPage labPage);
    }
}
