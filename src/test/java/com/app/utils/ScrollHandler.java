package com.app.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollHandler {
    public static void scroll(WebDriver driver, By scrollableLocator, int x, int y) {
        WebElement element = driver.findElement(scrollableLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript to scroll inside the element
        js.executeScript("arguments[0].scrollLeft += arguments[1]; arguments[0].scrollTop += arguments[2];", element, x,
                y);
    }
}
