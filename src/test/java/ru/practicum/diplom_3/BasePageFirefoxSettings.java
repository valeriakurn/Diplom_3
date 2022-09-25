package ru.practicum.diplom_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BasePageFirefoxSettings {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {

        WebDriverManager
                .firefoxdriver()
                .setup();

        driver = new FirefoxDriver();
        driver
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
