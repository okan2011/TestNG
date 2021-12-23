package com.techproed.tests.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day07_DependsOnMethods {


@Test
    public void logIn() {
    System.out.println("Login Test");
    Assert.assertTrue(true);

}
@Test(dependsOnMethods = "logIn")//logIn runs before the homepage
                                 //homepage method only runs if logIn PASS.
                                //Otherwise homePage will be SKIPPED
                                //homePage depends on the login method.
    public void homepage() {
    System.out.println("Home Page Test");
}

@Test (priority = 1)
    public void search () {
    System.out.println("Search Test");
}
@Test(priority = 2)
    public void searchResultTest () {
    System.out.println("Search Result Test");
}

}
