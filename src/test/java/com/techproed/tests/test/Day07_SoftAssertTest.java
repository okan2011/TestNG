package com.techproed.tests.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Day07_SoftAssertTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }
    @Test
    public void SoftAssertTest() {
    // Test case 01: search for 'iphone 12' and verify title contains 'iphone'
   driver.findElement(By.name("q")).sendKeys("iphone 12"+Keys.ENTER);
   String title1 = driver.getTitle();

   //STEP 1: Create SoftAssert object
       SoftAssert softAssert = new SoftAssert();
   //Step 2: Do Assertion
      softAssert.assertTrue(title1.contains("iphone 12"));//soft assert
     //  Assert.assertTrue(title1.contains("iphone 12"));//Hard Assert

        System.out.println("code after iphone");
    // TC02 :  search for 'porcelain teapot' and verify title contains 'porcelain teapot'
     softAssert.assertTrue(title1.contains("porcelain teapot"));//soft assert
     //   Assert.assertTrue(title1.contains("porcelain teapot"));

    //Since line 33 FAILED, rest of the code will not run. EXECUTION STOPS ON LINE 33

        System.out.println("code after teapot");
        //TC03 :  search for 'flower' and verify title contains 'flower'
     softAssert.assertTrue(title1.contains("flower"));//soft assert
   // Assert.assertTrue(title1.contains("flower"));

        System.out.println("code after flower");
    //STEP 3: AssertAll to mark the test case PASS or FAIL
   softAssert.assertAll();

    }

   @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
