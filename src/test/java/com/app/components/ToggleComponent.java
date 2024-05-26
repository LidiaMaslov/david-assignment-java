package com.app.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ToggleComponent {
    private WebDriver driver;
    private WebElement rootElement;

    public ToggleComponent(WebDriver driver, WebElement rootElement) {
        this.driver = driver;
        this.rootElement = rootElement;
    }

    public void toggleOn() {
        swipeTo(30);
    }

    public void toggleOff() {
        swipeTo(-30);
    }

    public void swipeTo(Integer x) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findToggleThumb())
                .clickAndHold()
                .moveByOffset(x, 0)
                .release()
                .perform();
    }

    public WebElement findToggleThumb() {
        WebElement toggleThumb = rootElement.findElement(By.xpath(".//div[@data-typename='Thumb']"));
        return toggleThumb;
    }
}
