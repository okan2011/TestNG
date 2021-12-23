package com.techproed.tests.test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Queue;

public class Day08_iframeTest extends TestBase {

//    Create a class: Day08_IFrameTest
//    Create a method: iframeTest
//    Go to https://the-internet.herokuapp.com/iframe
//    Verify the Bolded text contains “Editor”
//    Locate the text box
//    Delete the text in the text box
//    Type “This text box is inside the iframe”
//    Verify the text Elemental Selenium text is displayed on the page

    @Test
    public void iframeTest () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
           //    Verify the Bolded text contains “Editor”
      String headerText = driver.findElement(By.xpath("//h3")).getText();
                Assert.assertTrue(headerText.contains("Editor"));

    //The text box is inside the iframe. to access the text box first We need to switch to the iframe.
    //if we do not switch to the iframe we can not delete the text in the textbox.
   //  "//iframe" => xpath for iframe
        //there are 3 ways to switch to iframe
     // 1. Way: switching using id
       //     driver.switchTo().frame("mce_0_ifr");
      // 2. Way : switching 1st iframe using index
        //    driver.switchTo().frame(0);
      // 3. Way: switching to frame using the frame WebElement
WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
       driver.switchTo().frame(iframeElement);

      //NOW WE ARE INSIDE THE IFRAME

        //    Locate the text box
WebElement textBox = driver.findElement(By.xpath("//p"));
        //    Delete the text in the text box
      textBox.clear();
               //   Type “This text box is inside the iframe”
textBox.sendKeys("This text box is inside the iframe");
        //    Verify the text Elemental Selenium text is displayed on the page

        //Now we are inside the iframe. but text Elemental Selenium is outside the iframe.
        // so we need to go outside to locate the text Elemental Selenium.
        // there are two ways to switchto outside the iframe.
               //1. Way: driver.switchTo().parentFrame();
               //2. Way:  driver.switchTo().defaultContent();
driver.switchTo().defaultContent();
WebElement elementSelenium = driver.findElement(By.linkText("Elemental Selenium"));
Assert.assertTrue(elementSelenium.isDisplayed());

    }


    //
//    @Test
//    public void iframeTest () {
//        driver.get("https://the-internet.herokuapp.com/iframe");
//        //    Verify the Bolded text contains “Editor”
//                //  driver.findElement(By.xpath("//h3"));
//     String boldedText =  driver.findElement(By.xpath("//*[contains(text(),'TinyMCE')]")).getText();
//     Assert.assertTrue(boldedText.contains("Editor"));
//
//       //switching by using index
////       driver.switchTo().frame(0);
////       // switching by using id
////       driver.switchTo().frame("mce_0_ifr");
////       //switching by using WebElement
//        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
//        driver.switchTo().frame(iframeElement);
//        //NOW WE ARE IN THE IFRAME
//        //    Locate the text box
//        WebElement textBox =  driver.findElement(By.xpath("//p"));
//        // Delete the text in the text box
//        textBox.clear();
//      //  Type “This text box is inside the iframe”
//        textBox.sendKeys("This text box is inside the iframe");
//
//        //  Verify the text Elemental Selenium text is displayed on the page
//       // driver.switchTo().parentFrame();
//        driver.switchTo().defaultContent();
//        WebElement elementalSeleniumText = driver.findElement(By.linkText("Elemental Selenium"));
//        Assert.assertTrue(elementalSeleniumText.isDisplayed());
//    }






}
