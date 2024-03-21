package com.example.FlipkartUITesting;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
 
public class Testcase_002 {
 
    public static void main(String[] args) throws InterruptedException {
        // Set system properties for Chrome and Edge browsers
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\saikat_goswami\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//        System.setProperty("webdriver.edge.driver", "C:\\Users\\saikat_goswami\\Downloads\\edgedriver_win64\\msedgedriver.exe");
 
        // Create instances of WebDriver for Chrome and Edge
        WebDriver chromeDriver = new ChromeDriver();
//        WebDriver edgeDriver = new EdgeDriver();
 
        // Test Case 1: Advanced Product Search and Sorting
        addMultipleProductsandValidation(chromeDriver);

        // Close browser instances
        chromeDriver.quit();
    }
 
    public static void addMultipleProductsandValidation(WebDriver driver) throws InterruptedException {
        // Open the online store website
    	driver.get("https://www.flipkart.com/");
    	driver.manage().window().maximize();
 
        // Perform search for a specific product category (e.g., "laptops")
    	WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("laptops");
        searchBox.submit();
 
        // Wait for search results to load
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1AtVbE")));
        Thread.sleep(4000);
 
        // Apply advanced filters (e.g., brand, price range, specifications)
        //Brand
        WebElement brand = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[3]/div "));
        brand.click();
        WebElement hp = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[3]/div[2]/div[1]/div[1]/div/label/div[2]"));
        hp.click();
        
        Thread.sleep(4000);
        //Specifications
        WebElement i3 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div/div/section[5]/div[2]/div[1]/div[2]/div/label/div[1]"));
        i3.click();
      
 
        // Implement sorting functionality (e.g., sort by price)
        Thread.sleep(4000);
 
        WebElement sortByPriceOption = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div[1]/div/div/div[2]/div[3]"));
        sortByPriceOption.click();
        
        String mainPage = driver.getWindowHandle();
		System.out.println("Main page="+ mainPage);
        
        Thread.sleep(4000);
        
        //Clicking on the item
        driver.findElement(By.xpath("//div[@class='_4rR01T' and text()='HP 240 G8 Intel Core i3 11th Gen - (8 GB/512 GB SSD/DOS) 4K5D5PA Laptop']")).click();
        
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
           driver.switchTo().window(winHandle);
        }
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='row']//li//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")));
        
        //Add to cart
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww' and text()='ADD TO CART']")).click();
        
        
        //Main window
        Set<String> allPages=driver.getWindowHandles();
		for(String page : allPages) {
			if(!page.equals(mainPage)) {
				driver.switchTo().window(page);
				break;
			}
		}
		
		//Clicking on another item
		driver.findElement(By.xpath("//div[@class='_4rR01T' and text()='HP G Series Intel Core i3 10th Gen 1005G1 - (4 GB/512 GB SSD/Windows 10 Home) 250 G8 Thin and Light La...']")).click();
		
		//Add to cart
        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        
        
		
    }

    
        
  
        
        
    }

