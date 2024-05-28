package com.app.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LabPage extends BasePage {
    private By buttonDone = By.id("bDone");
    private By textNodeScore = By.xpath("//div[contains(text(), 'Your Score:')]");

    public LabPage(WebDriver driver) {
        super(driver);
    }

    public void pageLoaded() {
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        longWait.until(ExpectedConditions.visibilityOfElementLocated(buttonDone));
    }

    public void clickDone() {
        driver.findElement(buttonDone).click();
    }

    public String getScoreReport() {
        WebElement iframe = driver.findElement(By.id("_ifrmreport_"));
        driver.switchTo().frame(iframe);
        WebElement scoreElement = driver.findElement(textNodeScore);
        String scoreText = scoreElement.getText();
        driver.switchTo().defaultContent();
        return scoreText;
    }

}
