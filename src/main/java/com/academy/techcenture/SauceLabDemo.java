package com.academy.techcenture;

import com.sun.jna.Structure;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.academy.techcenture.CommonUtils.*;

import java.time.Duration;
import java.util.List;


public class SauceLabDemo {
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

        if (allItems.size() == elements.length) {
            System.out.println("ALL ITEMS ARE PRESENTED");
        } else {
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

        //step 14
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


        WebElement priceLowToHigh = driver.findElement(By.className("//select[@class='product_sort_container']/option"));
        Select select = new Select(priceLowToHigh);
        select.selectByValue("value");





        WebElement highPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price'])[6]"));
        String replace2 = highPrice.getText().replace("$", "");
        double newStringValue = Double.parseDouble(replace2);
        if (newStringValue == 49.99) {
            System.out.println("HIGH PRICE 49.99 IS MATCHED");
        } else {
            System.out.println("HIGH PRICE 49.99 IS NOT MATCHED");
        }


        WebElement firstPRDTIT = driver.findElement(By.id("item_2_title_link"));
        if (firstPRDTIT.isDisplayed()) {
            System.out.println("FIRST PRODUCT TITLE IS DISPLAYED");
        } else {
            System.out.println("FIRST PRODUCT TITLE IS DISPLAYED");
        }

        WebElement firstPRDDE = driver.findElement(By.className("inventory_item_desc"));
        firstPRDDE.getText();

        WebElement firstPRDPRICE = driver.findElement(By.className("inventory_item_price"));
        firstPRDPRICE.isDisplayed();


        WebElement lowPriceFirs = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]"));
        String replaceFirst = lowPriceFirs.getText().replace("$", "");
        double newStringFirst = Double.parseDouble(replaceFirst);
        if (newStringFirst == 7.99) {
            System.out.println("LOW PRICE 7.99 IS MATCHING");
        } else {
            System.out.println("LOW PRICE 7.99 IS NOT MATCHING");
        }

        WebElement firstAddBTN = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        if (firstAddBTN.isEnabled()) {
            System.out.println("FIRST ADD BUTTON IS CLICKABLE");
            firstAddBTN.click();
        } else {
            System.out.println("FIRST ADD BUTTON IS NOT CLICKABLE ");
        }
        WebElement firstRemoveBTN = driver.findElement(By.id("remove-sauce-labs-onesie"));
        if (firstRemoveBTN.equals("remove")) {
            System.out.println("REMOVE BUTTON IS THERE");
        } else {
            System.out.println("REMOVE BUTTON IS NOT THERE");
        }


        WebElement shoppingCartIcon = driver.findElement(By.id("shopping_cart_container"));
        if (!shoppingCartIcon.isSelected()) {
            System.out.println("SHOPPING CART ICON IS NOT SELECTED");
            shoppingCartIcon.click();
        } else {
            System.out.println("SHOPPING CART ICON IS SELECTED");
        }


        WebElement yourCartHeader = driver.findElement(By.className("header_secondary_container"));
        yourCartHeader.getText();


        WebElement cartQuantity = driver.findElement(By.className("cart_quantity"));
        String getValueCartQuantity = cartQuantity.getText();
        int getNEWValueCartQuantity = Integer.parseInt(getValueCartQuantity);
        if (getNEWValueCartQuantity == 1) {
            System.out.println("QUANTITY IS EQUALS TO 1");
        } else {
            System.out.println("QUANTITY IS NOT EQUALS TO 1");
        }

        WebElement checkoutBTN = driver.findElement(By.id("checkout"));
        if (checkoutBTN.isEnabled()) {
            System.out.println("CHUCK OUT BUTTON IS ENABLED");
            checkoutBTN.click();
        } else {
            System.out.println("CHUCK OUT BUTTON IS NOT ENABLED");
        }

        String[] splitName = randomNames().split("\\.");
        String firstName = splitName[1];
        String lastName = splitName[0];

        WebElement inputFirstName = driver.findElement(By.id("first-name"));
        inputFirstName.sendKeys(firstName);

        WebElement inputLastName = driver.findElement(By.id("last-name"));
        inputLastName.sendKeys(lastName);

        int zip =  (int) (Math.random() * (99999 - 11111) + 11111) ;
        WebElement postalCode = driver.findElement(By.id("postal-code"));
        postalCode.sendKeys(String.valueOf(zip));

        WebElement continueBTN = driver.findElement(By.id("continue"));
        if (continueBTN.isEnabled()) {
            System.out.println("BUTTON CONTINUE IS ENABLED");
            continueBTN.click();
        } else {
            System.out.println("BUTTON CONTINUE IS NOT ENABLED");
        }

        WebElement checkoutOverHeader = driver.findElement(By.xpath("//span[text()='Checkout: Overview'] "));
        if (checkoutOverHeader.isDisplayed()) {
            System.out.println("CHECKOUT HEADER IS THERE");
        } else {
            System.out.println("CHECKOUT HEADER IS NOT THERE");
        }

        WebElement paymentINFOLebel = driver.findElement(By.className("summary_info_label"));
        if (paymentINFOLebel.isDisplayed()) {
            System.out.println("PAYMENT INFORMATION LEBEL IS DISPLAYED");
        } else {
            System.out.println("PAYMENT INFORMATION LEBEL IS NOT DISPLAYED");
        }

        WebElement confirmationNMB = driver.findElement(By.className("summary_value_label"));
        String textConfirmation = confirmationNMB.getText();
        String[] splitTextConformation = textConfirmation.split("#");
        String newSplitTXT = splitTextConformation[1];
        int parseNewSplitTXT = Integer.parseInt(newSplitTXT);
        if (parseNewSplitTXT == 31337) {
            System.out.println("CONFORMATION NUMBER PRINTED SUCCESSFULLY");
        } else {
            System.out.println("CONFORMATION NUMBER DID NOT PRINTED");
        }

        WebElement shippingInfo = driver.findElement(By.className("summary_info_label"));
        shippingInfo.getText();


        WebElement priceTotal = driver.findElement(By.className("summary_total_label"));
        String priceTotalText = priceTotal.getText().replace("$", "");
        double parseDouble = Double.parseDouble(priceTotalText);
        if (parseDouble == total(7.99, 0.64)) {
            System.out.println("TOTAL PRICE IS MATCH");

        } else {
            System.out.println("TOTAL PRICE IS MATCH");
        }

        WebElement finishBTN = driver.findElement(By.id("finish"));
        if(finishBTN.isEnabled()){
            System.out.println("FINISH BUTTON IS ENABLED");
            finishBTN.click();
        }else {
            System.out.println("FINISH BUTTON IS NOT ENABLED");
        }


    }
}