package com.library.utility;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class BrowserUtils {
    //Methods are static. Because we do not want to create an object to call those methods.
    // We just want to call those methods with class name. That is why they are static type


    /**
     * This method is used to pause the code for given seconds
     * It is static method we can call with class name
     * BrowserUtils.sleep(3);
     * @param seconds
     */
    public static void sleep(int seconds){
         // 1 second = 1000 millis
        // millis = seconds*1000
         try {
             Thread.sleep(seconds*1000);
         }catch(InterruptedException e){
             e.printStackTrace();
             System.out.println("Exception happened in sleep method!");
         }
     }


     //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    // BrowserUtils.verifyTitle(driver,"Google")
    public static void verifyTitle(WebDriver driver, String expectedTitle){

        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }

public static void clickElement(WebElement element){

}
public static void  verifyTitle(){

}
    public static List<String> getAllSelectOptions(WebElement element){

        Select select=new Select(element);

        return getElementsText(select.getOptions());
    }
    /**
     * return a list of string from a list of elements
     *
     * @param list of webelements
     * @return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
}
