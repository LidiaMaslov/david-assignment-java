package com.app.navigation;

import com.app.pages.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Navigate {
    private WebDriver driver;
    private String baseUrl;

    public Navigate() {
        this.driver = Browser.start();
        this.baseUrl = System.getenv("SELENIUM_BASE_URL");
        if (this.baseUrl == null || this.baseUrl.trim().isEmpty()) {
            this.baseUrl = "https://testoutlivecontent.blob.core.windows.net";
        }
    }

    public void homePage(PageCallback<HomePage> callback) {
        loadPage(HomePage.class, callback);
    }

    public void settingsPage(PageCallback<SettingsPage> callback) {
        loadPage(SettingsPage.class, callback);
    }

    public void labPage(PageCallback<LabPage> callback) {
        loadPage(LabPage.class, callback);
    }

    public <T extends BasePage> void loadPage(Class<T> pageClass, PageCallback<T> callback) {
        T page = PageFactory.initElements(driver, pageClass);
        page.pageLoaded();
        callback.execute(page);
    }

    public interface PageCallback<T> {
        void execute(T page);
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

}
