package com.techproed.tests.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //Making abstract so don't create a TestBase object in other classes
   protected WebDriver driver;//we made WebDriver protected because we want to acces it from different packages.
    // by default the access modifier is default this means we can not access from different packages.
    // this "TestBase" class is in "Utilities" package and the "Test classes" are in "Test package"
    // We usually make the driver protected. it can be accessed from the child classes even in different packages.

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
    }

//    @AfterMethod
//    public void tearDown() {
//     driver.quit();

//    }
}