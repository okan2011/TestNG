package com.techproed.tests.test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_Synchronization2 extends TestBase {

//    Create a class:Day09_Synchronization2. Create a method: isEnabled
//    Go to https://the-internet.herokuapp.com/dynamic_controls
//    Click enable Button
//    And verify the message is equal to “It's enabled!”
//    And verify the textbox is enabled (I can type in the box)
//    And click on Disable button
//    And verify the message is equal to “It's disabled!”
//    And verify the textbox is disabled (I cannot type in the box)

@Test
    public void synchronization2() {

    driver.get("https://the-internet.herokuapp.com/dynamic_controls");

    //    Click enable Button
   driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

   // And verify the message is equal to “It's enabled!”    //p[@id='message']

    WebDriverWait wait = new WebDriverWait(driver,10);//we are appliying 10 seconds to driver.
    WebElement enabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
    String enabledMessageText = enabledMessage.getText();
    Assert.assertEquals(enabledMessageText,"It's enabled!");

    //    And verify the textbox is enabled (I can type in the box)
    WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
    Assert.assertTrue(textBox.isEnabled());//is Enables checks if an element is enable. Returns true if enabled, returns false if disabled

//    And click on Disable button
    driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]")).click();

//    And verify the message is equal to “It's disabled!”
    WebDriverWait wait1 = new WebDriverWait(driver,10);
    WebElement disabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
    String disabledMessageText = disabledMessage.getText();
    Assert.assertEquals(disabledMessageText,"It's disabled!");

//    And verify the textbox is disabled (I cannot type in the box)
    WebElement textBox1 = driver.findElement(By.xpath("//input[@type='text']"));
    Assert.assertFalse(textBox1.isEnabled());
}

 // @Test
// public void isEnabled() {
//  driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//
//  //    Click enable Button
//  driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
//
//  //    And verify the message is equal to “It's enabled!”
//  WebDriverWait wait = new WebDriverWait(driver,10);
// WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
// String messageText = message.getText();
// Assert.assertEquals(messageText,"It's enabled!");
//
////    And verify the textbox is enabled (I can type in the box)
//WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
//Assert.assertTrue(textbox.isEnabled());
//
////    And click on Disable button
//  driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
//
//  //    And verify the message is equal to “It's disabled!”
// // WebDriverWait wait = new WebDriverWait(driver,10);
//WebElement disabledMessage =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
//String disabledMessageText =  disabledMessage.getText();
//Assert.assertEquals(disabledMessageText,"It's disabled!");
//
////    And verify the textbox is disabled (I cannot type in the box)
// WebElement textbox1 =  driver.findElement(By.xpath("//input[@type='text']"));
// Assert.assertFalse(textbox1.isEnabled());
// }

}
