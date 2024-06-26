package com.example.FlipkartUITesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
 
public class Testcase_001 {
 
    public static void main(String[] args) throws InterruptedException {
        // Set system properties for Chrome and Edge browsers
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\saikat_goswami\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\saikat_goswami\\Downloads\\edgedriver_win64\\msedgedriver.exe");
 
        // Create instances of WebDriver for Chrome and Edge
        WebDriver chromeDriver = new ChromeDriver();
//        WebDriver edgeDriver = new EdgeDriver();
 
        // Test Case 1: Advanced Product Search and Sorting
        advancedProductSearchAndSorting(chromeDriver);
//        advancedProductSearchAndSorting(edgeDriver);
 
        // Close browser instances
        chromeDriver.quit();
//        edgeDriver.quit();
    }
 
    public static void advancedProductSearchAndSorting(WebDriver driver) throws InterruptedException {
        // Open the online store website
    	driver.get("https://www.flipkart.com/");
    	Thread.sleep(4000);
 
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
 
        // Wait for sorting to be applied
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1AtVbE")));
 
//        //Getting the prices
//        String price1 = driver.findElement(By.xpath("//div[@class='_30jeq3 _1_WHN1' and text()='₹29,990']")).getText();
//        String price2 = driver.findElement(By.xpath("//div[@class='_30jeq3 _1_WHN1' and text()='₹29,999']")).getText();
//        
//        assert Integer.parseInt(price1) <= Integer.parseInt(price2) : "Search results are not sorted by price";
        
//        List<WebElement> prices = driver.findElements(By.cssSelector("div._30jeq3"));
        
     // Check if there are at least two prices to compare
//     if (prices.size() < 1) {
//         System.out.println("Insufficient prices to compare.");
//         // Handle the case when there are not enough prices
//     } else {
//         for (int i = 0; i < prices.size() - 1; i++) {
//             String price1 = prices.get(i).getText().replace("₹", "").replace(",", "").trim();
//             String price2 = prices.get(i+1).getText().replace("₹", "").replace(",", "").trim();
//             try {
//                 int parsedPrice1 = Integer.parseInt(price1);
//                 int parsedPrice2 = Integer.parseInt(price2);
//                 // Compare prices
//                 assert parsedPrice1 <= parsedPrice2 : "Search results are not sorted by price";
//             } catch (NumberFormatException e) {
//                 System.out.println("Error parsing prices: " + e.getMessage());
//                 // Handle the case when price parsing fails
//             }
        
        String price1 = driver.findElement(By.cssSelector("#container > div > div._36fx1h._6t1WkM._3HqJxg > div > div:nth-child(2) > div:nth-child(2) > div > div > div > a > div._3pLy-c.row > div.col.col-5-12.nlI3QM > div._3tbKJL > div > div._30jeq3._1_WHN1")).getText();
        String price2 = driver.findElement(By.cssSelector("#container > div > div._36fx1h._6t1WkM._3HqJxg > div > div:nth-child(2) > div:nth-child(3) > div > div > div > a > div._3pLy-c.row > div.col.col-5-12.nlI3QM > div > div > div._30jeq3._1_WHN1")).getText();
        
        System.out.println(price1.compareTo(price2));
     }
    
    }
