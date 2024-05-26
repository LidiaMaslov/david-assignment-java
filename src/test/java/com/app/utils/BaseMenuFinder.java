package com.app.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseMenuFinder {
    private WebDriver driver;

    public BaseMenuFinder(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findByNameAndType(String name, String itemType) {
        List<WebElement> elements = driver
                .findElements(By.xpath("//div[starts-with(@data-typename, '" + itemType + "')]"));
        WebElement matchedElement = null;

        for (WebElement element : elements) {
            try {
                String normalizedText = normalizeText(element.getText());

                System.out.println("findMenu(" + name + "): \"" + normalizedText + "\"");

                if (normalizedText.equalsIgnoreCase(name)) {
                    if (matchedElement != null) {
                        throw new IllegalStateException("Multiple submenus found with the name \"" + name + "\"");
                    }
                    matchedElement = element;
                }
            } catch (StaleElementReferenceException e) {
                // Ignore and continue if the element becomes stale during iteration
                // That's because of scrollable container, it needs more complex code
                continue;
            }
        }

        if (matchedElement == null) {
            throw new NoSuchElementException("No submenu found with the name: '" + name + "'.");
        }

        return matchedElement;
    }

    private String normalizeText(String text) {
        return text.replace("›", "")
                .replaceAll("\n", " | ")
                .replaceAll("\\|\\s+$", "")
                .replaceAll("\\s+", " ")
                .trim();
    }
}
