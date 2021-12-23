package com.techproed.tests.test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_ActionsClass1 extends TestBase {
//    Create a class: ActionsClass1
//    Create a test method : contextClickMethod() and test the following scenario:
//    Given user is on the https://the-internet.herokuapp.com/context_menu
//    When use Right clicks on the box
//    Then verify the alert message is “You selected a context menu”
//    Then accept the alert

//Step 1:  Create the action object:
// Actions actions=new Actions(driver);
//Step 2:  Locate the WebElement you want to work on :
//  WebElement element = driver.findElement(By.id(“ID"));
//Step 3:  Perform the action on the WebElement by using this actions object.
// For instance, to right click: actions.contextClick(element).perform();
// perform() : Executes an action.This must be used at the end to perform an action.DO NOT FORGET TO USE PERFORM()


    @Test
    public void contextClickMethod() throws InterruptedException {
        //    Given user is on the https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //    When use Right clicks on the box
        WebElement box = driver.findElement(By.id("hot-spot"));

        // Create actions object, and use appropriate method of Actions
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();//we use contextClick for "right click"

        //    Then verify the alert message is “You selected a context menu”
       String alertText = driver.switchTo().alert().getText();
    //   System.out.println(alertText);//You selected a context menu

        Assert.assertEquals(alertText,"You selected a context menu");

        //    Then accept the alert
        driver.switchTo().alert().accept();



 //   @Test
//    //    Create a test method : contextClickMethod() and test the following scenario:
//    public void contextClick() throws InterruptedException {
//        //    Given user is on the https://the-internet.herokuapp.com/context_menu
//        driver.get("https://the-internet.herokuapp.com/context_menu");
//        //    When use Right clicks on the box
//        Actions actions = new Actions(driver);
//        WebElement textBox = driver.findElement(By.xpath("//div[@id='hot-spot']"));
//        actions.contextClick(textBox).perform();
//
//        //    Then verify the alert message is “You selected a context menu”
//        String alertText = driver.switchTo().alert().getText();
//        System.out.println(alertText);
//        Assert.assertEquals(alertText,"You selected a context menu");
//
//        //    Then accept the alert
//        Thread.sleep(5555);
//        driver.switchTo().alert().accept();
  }

    }





