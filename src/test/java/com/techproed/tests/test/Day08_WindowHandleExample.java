package com.techproed.tests.test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day08_WindowHandleExample extends TestBase {
    //    Create a new Class Tests package: Day08_WindowHandleExample
//    Method name:windowHandle
//    Given user is on the https://the-internet.herokuapp.com/windows
//    Then user verifies the text : “Opening a new window”
//    Then user verifies the title of the page is “The Internet”
//    When user clicks on the “Click Here” button
//    Then user verifies the new window title is “New Window”
//    Then user verifies the text:  “New Window”
//    When user goes back to the previous window and then verifies the title : “The Internet”

@Test
    public void windowHandle() throws InterruptedException {

//    Create a new Class Tests package: Day08_WindowHandleExample
//    Method name:windowHandle
//    Given user is on the https://the-internet.herokuapp.com/windows
//    Then user verifies the text : “Opening a new window”
//    Then user verifies the title of the page is “The Internet”
//    When user clicks on the “Click Here” button
//    Then user verifies the new window title is “New Window”
//    Then user verifies the text:  “New Window”
//    When user goes back to the previous window and then verifies the title : “The Internet”

    //    Given user is on the https://the-internet.herokuapp.com/windows
    driver.get("https://the-internet.herokuapp.com/windows");

    //    Then user verifies the text : “Opening a new window”
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    //    Then user verifies the title of the page is “The Internet”
        Assert.assertEquals(driver.getTitle(), "The Internet");
    //    When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();

        //Driver is still on the window 1. Although we physically see the new window the driver is still on the first window.
        //So we need to go to/switch to the new/second window.
    //to understand on which page the driver is we use driver.getCurrentUrl() method.
    System.out.println(driver.getCurrentUrl());
    //driver.getWindowHandle();//returns the id of the current windows

    //    How do you handle multiple windows
    //    Switch to the windows

    String window1 = driver.getWindowHandle();//returns the id of the current window

    Set<String> allWindows = driver.getWindowHandles();//returns all windows.
    //we use Set of String. Not list of String or list of elements. getWindowsHandles returns Set. because it returns unique window, unique elements.
    //All windows has window1 and window2
    for (String eachWindow: allWindows) {
       // System.out.println("window Handles : " + eachWindow);
         Thread.sleep(3000);

//        This switches window 1 first then window2 So I need to use if condition so I don't switch to window1
//        driver.switchTo().window(eachWindow);
//        System.out.println(eachWindow);
      //If driver is already on window1 we do not switch.
      //If driver is NOT on window1 then we switch to the other window
       if(!eachWindow.equals(window1)) {
           driver.switchTo().window(eachWindow);
           System.out.println(driver.getCurrentUrl());
     }

    // NOW DRIVER IS ON THE NEW WINDOW 2
        //  Then user verifies the new window title is “New Window”

    }

    //    Then user verifies the text:  “New Window”
        Assert.assertEquals(driver.getTitle(), "New Window");
    //Print the heading text of New Window
    System.out.println(driver.findElement(By.xpath("//h3")).getText());

    //    When user goes back to the previous window and then verifies the title : “The Internet”

    // DRIVER IS ON WINDOW2
    // To switch window1 we need to use loop again

    String window2 = driver.getWindowHandle();//getting the window2 handle
    for (String eachWindow:allWindows) {
        Thread.sleep(3000);
        if(!eachWindow.equals(window2)) {
            driver.switchTo().window(eachWindow);
        }
    }
    System.out.println(driver.getTitle());
    Assert.assertEquals(driver.getTitle(),"The Internet");

}

//@Test
//    public void windowHandle() throws InterruptedException {
//    driver.get("https://the-internet.herokuapp.com/windows");
////    Then user verifies the text : “Opening a new window”
//    WebElement text = driver.findElement(By.xpath("//h3"));
//    Assert.assertTrue(text.isDisplayed());
//    //    Then user verifies the title of the page is “The Internet”
//    Assert.assertEquals(driver.getTitle(),"The Internet");
//    //    When user clicks on the “Click Here” button
//    driver.findElement(By.linkText("Click Here")).click();
//
////    Then user verifies the new window title is “New Window”
//    String window1 = driver.getWindowHandle();
//    Set<String> allWindows = driver.getWindowHandles();
//    System.out.println(driver.getCurrentUrl());
//    System.out.println(allWindows);
//    Thread.sleep(3000);
//    for(String eachWindow : allWindows) {
//        if(!eachWindow.equals(window1)) {
//            driver.switchTo().window(eachWindow);
//            System.out.println(driver.getCurrentUrl());
//        }
//    }
//   // Then user verifies the text:  “New Window”
//    Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
//    //    When user goes back to the previous window and then verifies the title : “The Internet”
//    //user goes back to the previous window
//    String window2 = driver.getWindowHandle();
//    Thread.sleep(3000);
//    for(String eachWindow: allWindows){
//        if(!eachWindow.equals(window2)) {
//            driver.switchTo().window(eachWindow);
//            System.out.println(driver.getCurrentUrl());
//        }
//    }
//    Thread.sleep(3000);
//        //then verifies the title : “The Internet”
//    System.out.println(driver.getTitle());
//    Assert.assertEquals(driver.getTitle(), "The Internet");
//}




}
