package com.example.FlipkartUITesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
 
public class BaseClass {
 
    protected WebDriver driver;
 
    @BeforeMethod
    public void setUp() {
        initializeDriver("chrome"); // Change to "edge" for Edge browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
 
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
 
    public void initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
System.setProperty("webdriver.chrome.driver", "C:\\Users\\saikat_goswami\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Users\\saikat_goswami\\Downloads\\edgedriver_win64\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Unsupported browser!");
        }
    }
}