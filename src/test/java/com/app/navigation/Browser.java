package com.app.navigation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
    private static WebDriver driver;

    public static WebDriver start() {
        WebDriverManager
                .chromedriver()
                .browserInDocker()
                .enableVnc()
                .enableRecording();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        String headless = System.getenv("HEADLESS_BROWSER");
        if (headless == "true" || headless == null) {
            options.addArguments("--headless", "--disable-gpu");
        } else {
            options.addArguments("--disable-gpu");
        }

        driver = new ChromeDriver(options);
        // Set base timeouts
        // I would use config class in real project
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }
}
