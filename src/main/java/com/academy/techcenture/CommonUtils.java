package com.academy.techcenture;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonUtils {
//    List<WebElement> listOfPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
//        for (int i = 0; i < listOfPrices.size(); i++) {
//        String replace3 = listOfPrices.get(i).getText().replace("$", "");
//        double newStringListValue = Double.parseDouble(replace3);
//
//
//
//    }


    public static String randomNames(){
      Faker faker = new Faker();
        String lastName = faker.name().lastName().toLowerCase();
        String firstName = faker.name().firstName().toLowerCase();

        return lastName + "." + firstName;

    }

    public static String randomZipCode(){
       // return new Faker().address().zipCode().substring(0,5);

        return (int) (Math.random() * (50000 - 40000) + 40000) + "";

    }

    public static double total(double item , double tax){
        double sum = 0;
        sum = item + tax;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(randomZipCode());
    }











}
