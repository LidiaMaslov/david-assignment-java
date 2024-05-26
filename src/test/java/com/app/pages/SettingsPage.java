package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.components.ToggleComponent;

import com.app.utils.AnimationHandler;
import com.app.utils.MainMenuFinder;
import com.app.utils.ScrollHandler;
import com.app.utils.SubMenuFinder;

public class SettingsPage extends BasePage {
    // Locators
    private By menuMailContactsCalendars = By.xpath("//div[@id='siMailContactsCalendars']");
    // Helpers
    private SubMenuFinder subMenuFinder;
    private MainMenuFinder mainMenuFinder;

    public SettingsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        subMenuFinder = new SubMenuFinder(driver);
        mainMenuFinder = new MainMenuFinder(driver);
    }

    public void pageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuMailContactsCalendars));
    }

    public void clickMainMenu(String name) {
        mainMenuFinder.findByName(name).click();
        AnimationHandler.waitForAnimationToComplete();
    }

    public void clickSubMenu(String name) {
        subMenuFinder.findByName(name).click();
        AnimationHandler.waitForAnimationToComplete();
    }

    public ToggleComponent findToggle(String name) {
        WebElement subMenu = subMenuFinder.findByName(name);
        ToggleComponent toggleComponent = new ToggleComponent(driver, subMenu);
        return toggleComponent;
    }

    /*
     * Those are methods from diffenent popups.
     * Should be refactored into separate popup classes.
     * 
     * Test would look even better:
     * 
     * settingsPage.advancedPopup((advancedPopUp) -> {
     *     advancedPopUp.findToggle("Use SSL").toggleOn();
     *     String sslPort = advancedPoptUp.subMenu.findByName("Use SSL").text();
     *     Assert.assertTrue(sslPort, "993".equals(sslPort));
     * })
     */

    // Any Popup
    public void clickTopButton(String name) {
        String xpath = "//div[@data-typename='ButtonArrow']//div[text()='" + name + "']";
        WebElement backButton = driver.findElement(By.xpath(xpath));
        backButton.click();
        AnimationHandler.waitForAnimationToComplete();
    }

    // Wifi password popup
    public void enterPassword(String password) {
        subMenuFinder.findByName("Password")
                .findElement(By.xpath("//input[@data-typename='PasswordBox']"))
                .sendKeys(password);
    }

    // Advanced popup
    public String getServerPort() {
        ScrollHandler.scroll(driver, By.id("hcHeaderedContentControl.Grid.svScrollViewer.Grid.Viewport"), 0, 50);
        return subMenuFinder.findByName("Server Port").findElement(By.id("tbServerPort")).getAttribute("value");
    }

}
