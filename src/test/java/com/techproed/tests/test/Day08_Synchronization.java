package com.techproed.tests.test;

//import com.techproed.tests.utilities.TestBase;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day08_Synchronization extends TestBase {
    //    Go to https://the-internet.herokuapp.com/dynamic_controls
    //    Click on remove button
    //    And verify the message is equal to “It's gone!”
    //    Then click on Add button
    //    And verify the message is equal to “It's back!”

    @Test
    public void synchronization1() {
//    Create a class:Day09_Synchronization1. Create a method: synchronization1
//    Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
  //    Click on remove button
        driver.findElement(By.xpath("(//button)[1]")).click();

//
//   //  =========IMPLICIT WAIT IS ALREADY IN THE DRIVER CLASS======
//    And verify the message is equal to “It's gone!”

//    WebElement goneMessageElement=driver.findElement(By.xpath("//p[@id='message']"));
//    String goneMessageText=goneMessageElement.getText();
//    Assert.assertEquals(goneMessageText,"It's gone!");

//    =========EXPLICIT WAIT================
//    Step 1 for explicit wait: Create wait object
    WebDriverWait wait = new WebDriverWait(driver,10);//we are appliying 10 seconds to driver.

//    Step 2 Use wait object with an EXPECTED CONDITION
//    WAITING FOR By.xpath("//p[@id='message']")  UP TO 10 SECONDS
//    IF THAT ELEMENT IS VISIBLE IN 10 SECONDS THEN IT WILL RETURN THE ELEMENT
//    SO WE DON'T NEED TO USE findElement IF WE ARE USING EXPLICIT WAIT
    WebElement goneMessageElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
       String goneMessageText=goneMessageElement.getText();
        Assert.assertEquals(goneMessageText,"It's gone!");

    //    COMPLETE AS HOMEWORK. REPEAT LINE 36,37,38. JUST REPLACE The Locator and variable names

 //    Then click on Add button
        driver.findElement(By.xpath("//button[1]")).click();
       //    And verify the message is equal to “It's back!”
        //BELOW DOES 2 THINGS
        // 1. waits up to 10 seconds
        // 2. returns as web elements
       WebElement backMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
       String backMessageText = backMessage.getText();
       String expectedBackMessageText = "It's back!";
       Assert.assertEquals(backMessageText,expectedBackMessageText);
//    visibilityOfElementLocated one of the most used explicit wait
//    this waits for the locator to be visible on the page

    }



 //   @Test
//    public void expclicitWait() {
//        //    Go to https://the-internet.herokuapp.com/dynamic_controls
//        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        //    Click on remove button
//        driver.findElement(By.xpath("(//button)[1]")).click();
//        //    And verify the message is equal to “It's gone!”
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement gone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
//        String goneText = gone.getText();
//        Assert.assertEquals(goneText, "It's gone!");
//        //    Then click on Add button
//        driver.findElement(By.xpath("(//button)[1]")).click();
//        //    And verify the message is equal to “It's back!”
//        WebDriverWait wait1 = new WebDriverWait(driver, 10);
//        WebElement back = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
//        String backText = back.getText();
//        Assert.assertEquals(backText, "It's back!");
//
//
//    }




}
