package com.techproed.tests.test;

import com.techproed.tests.utilities.TestBase;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class Day23_HandlingCookies extends TestBase {
    @Test
    public void handleCookies() {

 /*
-It is created by the browser temporarily.
-Cookies are stored in our computers as we visit the websites
-We can automate handling cookies:
    -find the cookies
    -add new cookies
    -delete cookies
    */
driver.get("https://www.amazon.com");

     //getCookies() returns all of the cookies
        Set<Cookie> allCookies = driver.manage().getCookies();//this will return all cookies in the page

        //1. Find the total number of cookies
        int numberOfCookies = allCookies.size();
        System.out.println("Num Of Cookies : " + numberOfCookies);

    // 2. Print all cookies.
        for(Cookie eachCookies:allCookies) {
            System.out.println("Name : " + eachCookies.getName());
            System.out.println("Value : " + eachCookies.getValue());
        }

        // 3.Get cookies based on the name
       System.out.println("Cookie named sp-cdn : " + driver.manage().getCookieNamed("sp-cdn"));

  // 4. Add new cookie
        Cookie myCookies = new Cookie("MyBestCookies", "123456");
        driver.manage().addCookie(myCookies);
        allCookies= driver.manage().getCookies();
        int newNumberOfCookies = allCookies.size();
        System.out.println("Number of Cookies :" + newNumberOfCookies);

    // 5. Delete Cookies
    driver.manage().deleteCookieNamed("session-token");
    allCookies = driver.manage().getCookies();
    int lastNumberOfCookies = allCookies.size();
        System.out.println("Number of Cookies : " + lastNumberOfCookies);

    // 6. Delete all cookies
        driver.manage().deleteAllCookies();
        allCookies=driver.manage().getCookies();
        System.out.println("Number of Cookies : " + allCookies.size());


    }

}
