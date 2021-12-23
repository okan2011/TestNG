package com.techproed.tests.test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Day09_ActionsClass2 extends TestBase {
//
//    Create a class: ActionClass2
//    Create test method : hoverOver() and test the following scenario:
//    Given user is on the https://www.amazon.com/
//    When user click on “Account” link
//    Then verify the page title contains “Your Account”

    @Test
    public void hoverOver() throws InterruptedException {
        //    Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        WebElement accountAndList = driver.findElement(By.id("nav-link-accountList"));

        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(accountAndList).perform();//move the mouse over the accountAndList
        Thread.sleep(3000);

        //  WE CAN GET ALL OF THE LINKS AS LIST<WEBELEMENT>
    //("//div[@id='nav-al-your-account']//span")==>gives me All span elements under div[@id='nav-al-your-account']
        List<WebElement> allElements = driver.findElements(By.xpath("//div[@id='nav-al-your-account']//span"));
        for (WebElement eachElement : allElements) {
            System.out.println(eachElement.getText());
        }
        WebElement accountLink = driver.findElement(By.linkText("Account"));
        //    When use click on “Account” link
        accountLink.click();
//    Then verify the page title contains “Your Account”
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
        }

}


 //   @Test
//    public void hoverOver() {
//    //    Given user is on the https://www.amazon.com/
//    driver.get("https://www.amazon.com/");
//
////    When user click on “Account” link
//WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
//Actions actions =new Actions(driver);
//actions.moveToElement(accountList).perform();
//
//WebElement account = driver.findElement(By.linkText("Account"));
//account.click();
//
////    Then verify the page title contains “Your Account”
//    String title = driver.getTitle();
//    Assert.assertTrue(title.contains("Your Account"));
//
//}


