package com.techproed.tests.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileExistTest {

//    Class: FileExistTest
//    Method: isExist
//    Pick a file on your desktop
//    And verify if that file exist on your computer or not


        @Test
    public void isExist () {
  // we can not automate desktop application with selenium
  //But we can use JAVA to understand a file path exist in our computers.


   // OR WE CAN GET THE PATH DYNAMICALLY USING JAVA
   String homePath = System.getProperty("user.home");
   System.out.println(homePath);
  //String pathOfFile = "/Users/KARACA/Desktop/flower.jpeg";

   String pathOfFile = homePath+"/Downloads/flower.jpg";//  /Users/KARACA/Desktop/flower.jpeg
            System.out.println(pathOfFile);

    // Check if the file exist in your computer?
            boolean isExists = Files.exists(Paths.get(pathOfFile));// Returns true if pathOfFile exist on the computer. returns false if pathOfFile does not exist on the computer
            Assert.assertTrue(isExists);

 }

//    @Test
//    public void isExists() {
//
//        String pathOfFile = "C://Users//KARACA//Downloads//flower.jpg";
//        System.out.println(pathOfFile);
//        String homePath = System.getProperty("user.home");
//        System.out.println(homePath);
//        String path = homePath + "/Downloads/flower.jpg";
//        System.out.println(path);
//
//       boolean isExists = Files.exists(Paths.get(path));
//    Assert.assertTrue(isExists);
//    }

}
