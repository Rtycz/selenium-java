package ru.mirapolis;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {

    public ChromeDriver driver;


    @BeforeEach
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","src\\Chromedriver\\Chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test started\n");
    }

    @AfterEach
    public void close()
    {
        driver.quit();
        System.out.println("Test ended\n");
    }

    @Before
    public void setUp1()
    {
        System.setProperty("webdriver.chrome.driver","src\\Chromedriver\\Chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Test started\n");
    }
}
