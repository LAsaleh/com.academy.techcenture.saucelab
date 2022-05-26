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

    public static void main(String[] args) throws InterruptedException {

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

        String readTitle2 = driver.getTitle();
        if (readTitle2.equals("Swag Labs")) {
            System.out.println("YES TITLE IS THERE");
        } else {
            System.out.println("TITLE IS NOT THERE");
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


        String readNewTabTitle = driver.getTitle();
        if(readNewTabTitle.equals("Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs")){
            System.out.println("NEW TAB TITLE IS THERE");
        }else {
            System.out.println("NEW TAB TITLE IS NOT THERE");
        }


        driver.navigate().back();




//        step 14

        List<WebElement> listsItemsPRD = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        if (listsItemsPRD.size() == 6) {
            System.out.println("SIX PRODUCTS ARE THERE");
        } else {
            System.out.println("SIX PRODUCTS ARE NOT THERE");
        }



        List<WebElement> listOfPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (int i = 0; i < listOfPrices.size(); i++) {
        String replace3 = listOfPrices.get(i).getText().replace("$", "");
        double newStringListValue = Double.parseDouble(replace3);
            System.out.println(newStringListValue);

    }


        //step 15

        WebElement filterPrices = driver.findElement(By.className("product_sort_container"));
        if (filterPrices.isEnabled()) {
            System.out.println("FILTER IS ENABLED");
            filterPrices.click();
        } else {
            System.out.println("FILTER IS NOT ENABLED");
        }


        WebElement priceLowHigh = driver.findElement(By.xpath("//option[@value='lohi']"));
        priceLowHigh.click();



        //step 16

        WebElement lowPriceFirs = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]"));
        String replaceFirst = lowPriceFirs.getText().replace("$", "");
        double newStringFirst = Double.parseDouble(replaceFirst);
        if (newStringFirst == 7.99) {
            System.out.println("LOW PRICE 7.99 IS MATCHING");
        } else {
            System.out.println("LOW PRICE 7.99 IS NOT MATCHING");
        }

//
//        WebElement highPrice = driver.findElement(By.xpath("//div[@class='inventory_item_price'])[2]"));
//        String replace2 = highPrice.getText().replace("$", "");
//        double newStringValue = Double.parseDouble(replace2);
//        if (newStringValue == 49.99) {
//            System.out.println("HIGH PRICE 49.99 IS MATCHED");
//        } else {
//            System.out.println("HIGH PRICE 49.99 IS NOT MATCHED");
//        }


        //step17

        WebElement firstTitleProduct = driver.findElement(By.className("inventory_item_name"));
        firstTitleProduct.click();


      if(driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs')]")).getText().equals("Sauce Labs Onesie")){
          System.out.println("FIRST PRODUCT TITLE IS THERE");
      }else {
          System.out.println("FIRST PRODUCT TITLE IS NOT THERE");
      }
        WebElement firstProductDetail = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs')]"));
        boolean firstProductTitle = firstProductDetail.getText().equalsIgnoreCase("Sauce Labs Onesie");
        if(firstProductTitle) {
            System.out.println(firstProductDetail.getText());

        }

        WebElement priceFirstPRD = driver.findElement(By.className("inventory_details_price"));
        if(priceFirstPRD.equals("$ 7.99")){
            System.out.println("FIRST PRODUCT PRICE IS MATCHING");
        }else {
            System.out.println("FIRST PRODUCT PRICE IS MATCHING");
        }


        //step19 & 20
        WebElement firstAddBTN = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        if (firstAddBTN.isEnabled()) {
            System.out.println("FIRST ADD BUTTON IS CLICKABLE");
            firstAddBTN.click();
        } else {
            System.out.println("FIRST ADD BUTTON IS NOT CLICKABLE ");
        }


        //step 21
        WebElement firstRemoveBTN = driver.findElement(By.id("remove-sauce-labs-onesie"));
        if (firstRemoveBTN.isDisplayed()) {
            System.out.println("REMOVE BUTTON IS THERE");
        } else {
            System.out.println("REMOVE BUTTON IS NOT THERE");
        }


        //step 22
        WebElement shoppingCartIcon = driver.findElement(By.id("shopping_cart_container"));
        if (!shoppingCartIcon.isSelected()) {
            System.out.println("SHOPPING CART ICON IS NOT SELECTED");
            shoppingCartIcon.click();
        } else {
            System.out.println("SHOPPING CART ICON IS SELECTED");
        }

        //step23
        WebElement yourCartHeader = driver.findElement(By.className("header_secondary_container"));
        if(yourCartHeader.isDisplayed()){
            System.out.println("YOUR CART HEADER IS THERE");
        }else{
            System.out.println("YOUR CART HEADER IS NOT THERE");
        }



        //step23
        WebElement cartQuantity = driver.findElement(By.className("cart_quantity"));
        String getValueCartQuantity = cartQuantity.getText();
        int getNEWValueCartQuantity = Integer.parseInt(getValueCartQuantity);
        if (getNEWValueCartQuantity == 1) {
            System.out.println("QUANTITY IS EQUALS TO 1");
        } else {
            System.out.println("QUANTITY IS NOT EQUALS TO 1");
        }

        //step24 & 25
        WebElement checkoutBTN = driver.findElement(By.id("checkout"));
        if (checkoutBTN.isEnabled()) {
            System.out.println("CHUCK OUT BUTTON IS ENABLED");
            checkoutBTN.click();
        } else {
            System.out.println("CHUCK OUT BUTTON IS NOT ENABLED");
        }

        //step26
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


        //step 27
        WebElement continueBTN = driver.findElement(By.id("continue"));
        if (continueBTN.isEnabled()) {
            System.out.println("BUTTON CONTINUE IS ENABLED");
            continueBTN.click();
        } else {
            System.out.println("BUTTON CONTINUE IS NOT ENABLED");
        }



        //step28
        WebElement checkoutOverHeader = driver.findElement(By.xpath("//span[text()='Checkout: Overview'] "));
        if (checkoutOverHeader.isDisplayed()) {
            System.out.println("CHECKOUT HEADER IS THERE");
        } else {
            System.out.println("CHECKOUT HEADER IS NOT THERE");
        }

        //step29
        WebElement paymentINFOLebel = driver.findElement(By.className("summary_info_label"));
        if (paymentINFOLebel.isDisplayed()) {

            System.out.println("PAYMENT INFORMATION LEBEL IS DISPLAYED");
        } else {
            System.out.println("PAYMENT INFORMATION LEBEL IS NOT DISPLAYED");
        }

        //step29
        WebElement confirmationNMB = driver.findElement(By.className("summary_value_label"));
        String textConfirmation = confirmationNMB.getText();
        String[] splitTextConformation = textConfirmation.split("#");
        String newSplitTXT = splitTextConformation[1];
        int parseNewSplitTXT = Integer.parseInt(newSplitTXT);
        if (parseNewSplitTXT == 31337) {
            System.out.println("CONFORMATION 31337 NUMBER PRINTED SUCCESSFULLY");
        } else {
            System.out.println("CONFORMATION 31337 NUMBER DID NOT PRINTED");
        }

        //step30
        WebElement shippingInfo = driver.findElement(By.xpath("//div[contains(text(),'FREE PONY')]"));
        if(shippingInfo.getText().equals("FREE PONY EXPRESS DELIVERY!")){
            System.out.println("SHIPPING TEXT IS THERE");
        }else {
            System.out.println("SHIPPING TEXT IS NOT THERE");
        }


        //step31
        String[] splitTotalItem = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText().split("\\$");
        double parseDoubletTotalItem = Double.parseDouble(splitTotalItem[1]);

        String[] splitTax = driver.findElement(By.className("summary_tax_label")).getText().split("\\$");
        double parseDoubleTax = Double.parseDouble(splitTax[1]);

        String[] splitTotal = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText().split("\\$");
        double parseDoubleTotal = Double.parseDouble(splitTotal[1]);

        if  ((parseDoubletTotalItem + parseDoubleTax ) == parseDoubleTotal){
            System.out.println("TOTAL PRICE IS ACCURATE");
        }else {
            System.out.println("TOTAL PRICE IS ACCURATE");
        }


        //step32
        WebElement finishBTN = driver.findElement(By.id("finish"));
        if(finishBTN.isEnabled()){
            System.out.println("FINISH BUTTON IS ENABLED");
            finishBTN.click();
        }else {
            System.out.println("FINISH BUTTON IS NOT ENABLED");
        }

        //step33
        boolean thankYou = driver.findElement(By.className("complete-header")).isDisplayed();
        if(thankYou){
        System.out.println("Thank you for your order is displayed");
       }else {
            System.out.println("Thank you for your order is not displayed");
        }

        WebElement textFinalizeOrder = driver.findElement(By.xpath("//div[@class='complete-text']"));
        if(textFinalizeOrder.getText().equalsIgnoreCase("Your order has been dispatched, and will arrive just as fast as the pony can get there!")){
            System.out.println("TEXT IS DISPLAYED");
        }else {
            System.out.println("TEXT IS NOT DISPLAYED");
        }

        WebElement ponyExpressImage = driver.findElement(By.className("pony_express"));
        if(ponyExpressImage.isDisplayed()){
            System.out.println("PONY EXPRESS IMAGE IS THERE");
        }else {
            System.out.println("PONY EXPRESS IMAGE IS NOT THERE");
        }

        //step34
        WebElement backHomeBTN = driver.findElement(By.id("back-to-products"));
        if(backHomeBTN.isEnabled()){
            System.out.println("BACK HOME BUTTON IS ENABLED");
            backHomeBTN.click();
        }else {
            System.out.println("BACK HOME BUTTON IS  NOT ENABLED");
        }


        driver.findElement(By.id("react-burger-menu-btn")).click();

        driver.findElement(By.id("logout_sidebar_link")).click();


        Thread.sleep(3000);

        driver.close();
        Thread.sleep(4000);
        driver.quit();

//    }
}}