package com.techproed.tests.test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day09_ActionsClass3 extends TestBase {

    @Test
    public void keysUpDown() throws InterruptedException {

//        Create a class: ActionsClass3
//        Create test method : keysUpDown()
//        Go to google
//        Send iPhone X prices => convert small letter capital vice versa.
//        Highlight the search box by double clicking


        driver.get("https://www.google.com");
        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.name("q"));
       // searchBox.sendKeys("iPhone X prices ");//Normal search
        Actions actions = new Actions(driver);
        //actions.keyDown("WEBELEMENT" "COMMAND LIKE KeysUp or KeysDown or KeyShift")
        Thread.sleep(3000);
        actions.keyDown(searchBox, Keys.SHIFT).//Pressing Shift on keyboard

                sendKeys("iphone x prices"). //sending small letters and expecting capital letters being typed
                keyUp(searchBox,Keys.SHIFT).
                sendKeys(" too expensive").doubleClick().
                perform();                  // performing the task

        //   INPUT                                OUTPUT
        //  iphone X prices     ==> IPHONE X PRICES because I am testing if capital letter search works

    }

//    @Test
//    public void keysUpDown() {
//        driver.get("https://www.google.com");
//        WebElement textBox = driver.findElement(By.name("q"));
//        textBox.sendKeys("iPhone X prices");
//
//        Actions actions = new Actions(driver);
//        actions.keyDown(textBox,Keys.SHIFT).sendKeys("iPhone X prices").perform();
//    }

}
