package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumTrial {
    protected static WebDriver driver;


    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //open the browser
        driver.get("https://demo.nopcommerce.com/");
        //click on register button
        driver.findElement(By.className("ico-register")).click();
        //type firstName
        driver.findElement(By.id("FirstName")).sendKeys("Dixit");
        //type lastname
        driver.findElement(By.id("LastName")).sendKeys("patel");
        //Email Id
        driver.findElement(By.id("Email")).sendKeys("abcde2@gmail.com");
        // Type password
        driver.findElement(By.id("Password")).sendKeys("Test1234");
        // type Confirmpassword
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Test1234");
        //Click on Register submit button
        driver.findElement(By.id("register-button")).click();

        // verify correct registration message display
        String actualmessage = driver.findElement(By.className("result")).getText();
        String expectedRegisterMsg = driver.findElement(By.className("result")).getText();
        if ((actualmessage.equals(expectedRegisterMsg))) {
            System.out.println("pass");
        } else {
            System.out.println("Failed");

        }
        driver.close();


    }
}
