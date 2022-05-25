package com.academy.techcenture;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CommonUtils {
    final public static String URL = "https://www.saucedemo.com/";
    final public static String USER_NAME = "standard_user";
    final public static String PASSWORD = "secret_sauce";

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.navigate().to(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).
                executeScript("return document.readyState").equals("complete"));

        String readTitle = driver.getTitle();
        if (readTitle.equals("Swag Labs")) {
            System.out.println("YES TITLE IS THERE");
        } else {
            System.out.println("TITLE IS NOT THERE");
        }

        WebElement swagLogo = driver.findElement(By.className("login_logo"));
        if (swagLogo.isDisplayed()) {
            System.out.println("SWAG LOGO IS DISPLAYED");
        } else {
            System.out.println("SWAG LOGO IS NOT DISPLAYED");
        }

        WebElement swagLogoImg = driver.findElement(By.className("bot_column"));
        if (swagLogoImg.isDisplayed()) {
            System.out.println("SWAG LOGO IMAGE IS THERE");
        } else {
            System.out.println("SWAG LOGO IMAGE IS NOT THERE");
        }


        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys(USER_NAME);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(PASSWORD);


        WebElement logInBTN = driver.findElement(By.id("login-button"));
        if (logInBTN.isEnabled()) {
            System.out.println("LOG IN BUTTON IS ENABLED");
            logInBTN.click();
        } else {
            System.out.println("LOG IN BUTTON IS NOT ENABLED");
        }

        WebElement logoTitle = driver.findElement(By.xpath("//title[text()='Swag Labs']"));
        if (logoTitle.isDisplayed()) {
            System.out.println("VERIFIED");
        } else {
            System.out.println("NOT VERIFIED");
        }

        WebElement productsTitle = driver.findElement(By.className("title"));
        if (productsTitle.isDisplayed()) {
            System.out.println("CHECKED SUCCESSFULLY");
        } else {
            System.out.println("CHECKED UNSUCCESSFULLY");
        }
        WebElement menuBTN = driver.findElement(By.id("react-burger-menu-btn"));
        if (menuBTN.isEnabled()) {
            System.out.println("MENU IS ENABLED");
            menuBTN.click();
        } else {
            System.out.println("MENU IS NOT ENABLED");
        }


        String[] elements = {"all items", "about", "logout", "reset app state"};
        List<WebElement> allItems = driver.findElements(By.xpath("//a[contains(@class,'bm-item')]"));

        if (allItems.size() == 4){
            System.out.println("ALL ITEMS ARE PRESENTED");
        }else{
            System.out.println("ALL ITEMS ARE NOT PRESENTED");
        }

        WebElement aboutListBTN = driver.findElement(By.id("about_sidebar_link"));
        aboutListBTN.click();

        WebElement aboutListBTNTitle = driver.findElement(By.xpath("//title[text()='Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs']"));
        if (aboutListBTNTitle.isDisplayed()) {
            System.out.println("CROSS BROWSER IS DISPLAYED");
        } else {
            System.out.println("CROSS BROWSER IS NOT DISPLAYED");
        }

        driver.navigate().back();

        List<WebElement> listsItemsPRD = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        if (listsItemsPRD.size() == 6) {
            System.out.println("SIX PRODUCTS ARE THERE");
        } else {
            System.out.println("SIX PRODUCTS ARE NOT THERE");
        }

        WebElement filterPrices = driver.findElement(By.className("product_sort_container"));
        if (filterPrices.isEnabled()) {
            System.out.println("FILTER IS ENABLED");
            filterPrices.click();
        } else {
            System.out.println("FILTER IS NOT ENABLED");
        }

        WebElement priceLTOH = driver.findElement(By.xpath("//option[@value='lohi']"));
        priceLTOH.click();

        WebElement lowPrice = driver.findElement(By.xpath("//div[text()='7.99']"));
        if (lowPrice.equals("7.99") && lowPrice.isDisplayed()) {
            System.out.println("LOW PRICE IS 7.99$");
        } else {
            System.out.println("LOW PRICE IS NOT 7.99");
        }



    }
}