package com.techproed.tests.test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day07_TestBaseDemo extends TestBase {
    //We are using TestBase
    //BeforeMethod and AfterMethod automatically runs
    //This test class is now cleaner

//    Create a class:TestBaseDemo
//    Create two methods: test1, test2
//    test1 search “porcelain teapot” on google
//    Then verify page contains “porcelain teapot”
//            ——————————-
//    test2 search “porcelain teapot” on amazon
//    Then verify page contains “porcelain teapot”

    @Test
    public void test1() {
        //test1 search “porcelain teapot” on google
    driver.get("https://www.google.com");
    driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);
//    Then verify page contains “porcelain teapot”
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));

    }
    @Test
    public void test2(){
     //   test2 search “porcelain teapot” on amazon
       driver.get("https://amazon.com");

       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot"+Keys.ENTER);
     //  Then verify page contains “porcelain teapot”
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }

}
