package com.techproed.tests.test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_FileUploadTest extends TestBase {

//    Class Name: FileUploadTest
//    Method Name: fileUploadTest
//    When user goes to https://the-internet.herokuapp.com/upload
//    And click on the chooseFile button
//    And selects an image from the computer
//    And click on the Upload button
//    Then verify the File uploaded!  Message displayed

    @Test
    public void fileUploadTest() throws InterruptedException {
//    When user goes to https://the-internet.herokuapp.com/upload
        driver.get ("https://the-internet.herokuapp.com/upload");
//    And click on the chooseFile button
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        //chooseFileButton.click();// did not work

        //And selects an image from the computer
        //to upload a file to input type="file", we send the path of the file to this input

        //FIND THE PATH OF THE FILE
        String homePath = System.getProperty("user.home");
        String pathOfFile = homePath+"/Downloads/flower.jpg";//  /Users/KARACA/Desktop/flower.jpeg
        Thread.sleep(4000);
// SEND THE pathOfFile in the chooseFileButton
        chooseFileButton.sendKeys(pathOfFile);
        Thread.sleep(4000);
//    And click on the upload button
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(4000);
//    Then verify the File Uploaded!  Message displayed
        String uploadSuccessMessage = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(uploadSuccessMessage,"File Uploaded!");
    }


 //   @Test
//    public void fileUploadTest() throws InterruptedException {
//        driver.get("https://the-internet.herokuapp.com/upload");
//
//        //    And click on the chooseFile button
//
//        String pathOfFile = System.getProperty("user.home");
//        String path = pathOfFile + "/Downloads/flower.jpg";
//       WebElement chooseFile = driver.findElement(By.id("file-upload"));
//       Thread.sleep(3000);
//       chooseFile.sendKeys(path);
////    And click on the Upload button
//       driver.findElement(By.id("file-submit")).click();
//        //    Then verify the File Uploaded!  Message displayed
//      String fileUploadMessage =  driver.findElement(By.xpath("//h3")).getText();
//        System.out.println(fileUploadMessage);
//        Assert.assertEquals(fileUploadMessage,"File Uploaded!");
//    }


}
