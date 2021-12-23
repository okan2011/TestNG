package com.techproed.tests.test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day09_ActionsClass4 extends TestBase {
 //        Create a class: ActionClass4
//        Create test method : scrollUpDown()
//        Go to amazon
//        Scroll the page down
//        Scroll the page up



    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();

    }





//    @Test
//    public void scrollUpDown() throws InterruptedException {


//
//        driver.get("https://www.amazon.com");
//
//        Actions actions = new Actions(driver);
////        PAGE_DOWN ==> scrolling down
////        PAGE_UP ==> scrolling up
////        ARROW_DOWN ==> scrolling down
////        ARROW_UP ==> scrolling up
//            Thread.sleep(3000);
//        //scroll down
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(3000);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Thread.sleep(3000);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//        //ARROW_DOWN scrolls a little bit. This is same as clicking down button once on the keyboard.
//        actions.sendKeys(Keys.ARROW_DOWN).perform();
//        Thread.sleep(3000);
//        actions.sendKeys(Keys.ARROW_DOWN).perform();
//        Thread.sleep(3000);
//
//        Thread.sleep(3000);
//        //SCROLL_UP
//        actions.sendKeys(Keys.PAGE_UP).perform();
//        Thread.sleep(3000);
//        actions.sendKeys(Keys.PAGE_UP).perform();
//
//            //ARROW_UP moves the page a little bit
//        Thread.sleep(3000);
//        actions.sendKeys(Keys.ARROW_UP).perform();
//        Thread.sleep(3000);
//        actions.sendKeys(Keys.ARROW_UP).perform();
//
//
//
//
//
//    }


}
