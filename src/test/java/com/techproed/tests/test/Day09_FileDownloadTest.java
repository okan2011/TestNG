package com.techproed.tests.test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileDownloadTest extends TestBase {

//    Create a class:FileDownloadTest
//    downloadTest()
//    In the downloadTest() method, do the following test:
//    Go to https://the-internet.herokuapp.com/download
//    Download flower.png file
//    Then verify if the file downloaded successfully

    @Test
    public void downloadTest () throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");

        //    Download flower.png file
        driver.findElement(By.linkText("Cover1.jpg")).click();
        //driver.findElement(By.linkText("flower.jpeg")).click();
        Thread.sleep(3000);
        //    Then verify if the file downloaded successfully

       // I know the flower.jpeg will be in Downloads if download is successful
       // To verify if a path exist in our download folder I follow these steps
       //   1. to find the path of the flower.jpeg file
       //       filePath = home directory + /Downloads folder + file name with extension

      String flowerPath = System.getProperty("user.home") +"/Downloads/Cover1.jpg";
        // Alternate path : "/Users/KARACA/Desktop/flower.jpeg";

        //    Then verify if the file downloaded successfully
        boolean isExists = Files.exists(Paths.get(flowerPath));
        Assert.assertTrue(isExists);

    }
 //   @Test
//    public void downloadTest () {
//
//        driver.get("https://the-internet.herokuapp.com/download");
//        driver.findElement(By.linkText("flower.jpg")).click();
//        String path = System.getProperty("user.home");
//        System.out.println(path);
//        String pathOfFile = path+ "/downloads/flower.jpg";
//        System.out.println(pathOfFile);
//        boolean isExists =   Files.exists(Paths.get(pathOfFile));
//    }
}
