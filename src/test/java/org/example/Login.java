package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Login {


   static String expectedMsg = "Your registration completed";
    public static String email = "random-" + randomDate () + "@gmail.com";
    protected static WebDriver driver;

    public static void clicklOnElement(By by) {
        driver.findElement ( by ).click ();
    }

    public static void typeText(By by, String text) {
        driver.findElement ( by ).sendKeys ( text );
    }

    public static String getTextFromElement(By by) {

        return driver.findElement ( by ).getText ();
    }

    public static String randomDate() {
        DateFormat dateFormat = new SimpleDateFormat ( "ddmmyyyyhhmmss" );
        Date date = new Date ();
        return dateFormat.format ( date );
    }

    @BeforeSuite
    public static void openBrowser() {
        //open Browser
        driver = new ChromeDriver ();
        driver.manage ().timeouts ().implicitlyWait ( 20, TimeUnit.SECONDS );
        driver.manage ().window ().maximize ();
        //type URL
        driver.get ( "https://demo.nopcommerce.com/" );
    }

    @AfterSuite
    public static void tearOff() {
        driver.quit ();
    }


    @Test(priority = 1)
    public static void verifyUserShouldRegisterSuccessfully() {

        //click on register button
        clicklOnElement ( By.className ( "ico-register" ) );
        //type firstName
        typeText ( By.id ( "FirstName" ), "Dixit" );
        //type lastname
        typeText ( By.id ( "LastName" ), "Patel" );
        //Email Id

        typeText ( By.id ( "Email" ), email );
        // Type password
        typeText ( By.name ( "Password" ), "Test1234" );
        // type Confirmpassword
        typeText ( By.name ( "ConfirmPassword" ), "Test1234" );
        //Click on Register submit button
        clicklOnElement ( By.id ( "register-button" ) );
        String actual = getTextFromElement ( By.className ( "result") );
        Assert.assertEquals ( actual,expectedMsg,"You are not registered" );
        if (actual.equals ( expectedMsg )){
            System.out.println ("The test is pass");
        }
        else {
            System.out.println ("The test is fail");
        }

    }


    @Test(priority = 2)
    public static void verifyUserShouldLoginSuccessfully() throws InterruptedException {

        clicklOnElement ( By.className ( "ico-login" ) );
        typeText ( By.id ( "Email" ), email );
        // Type password
        typeText ( By.name ( "Password" ), "Test1234" );
        // click on Login button
        clicklOnElement ( By.xpath ( "//button[contains(@class,'login-button')]" ) );
        Thread.sleep ( 2000 );
        WebElement logoutBtn = driver.findElement ( By.className ( "ico-logout" ) );
        //Assertion
        Assert.assertTrue ( logoutBtn.isDisplayed () );
    }

    @Test(priority = 3)
    public static void verifyUsershouldAbletoGoTOElectronicsFunction() {

        clicklOnElement ( By.xpath ( ("(//a[contains(@href,'electronics')])[1]") ) );
        //open camera and photo function
        clicklOnElement ( By.xpath ( "(//a[contains(@href,'camera-photo')])[4]" ) );
        // Add to cart  open camera and photo function
        clicklOnElement ( By.xpath ( "//button[contains(@class,'add-to-cart-button')]" ) );



    }

}





