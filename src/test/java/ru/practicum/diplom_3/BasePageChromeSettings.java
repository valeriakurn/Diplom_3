package ru.practicum.diplom_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasePageChromeSettings {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager
                .chromedriver()
                .setup();

        driver = new ChromeDriver();
        driver
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
