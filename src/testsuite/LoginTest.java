package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

       String baseUrl = "https://courses.ultimateqa.com/";

       @Before
       public void setUp(){
              openBrowser(baseUrl);

       }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully () {

        //  click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Verify the text ‘Welcome Back!’
        String actualText = driver.findElement(By.xpath("//h1[@class='page__heading']")).getText();

        //as per requirement
        String expectedText = "Welcome Back!";
        Assert.assertEquals("verify text", expectedText, actualText);

    }
    @Test
    public void verifyTheErrorMessage () {

        //  click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Enter invalid username
        WebElement email = driver.findElement(By.id("user[email]"));
        email.sendKeys("abc@gmail.com");

        // Enter invalid password
        WebElement passWord = driver.findElement(By.id("user[password]"));
        passWord.sendKeys("123456");
        // Click on Login button

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //Verify the error message Invalid email or password.

        String actualtext = driver.findElement(By.xpath("//li[@class='form-error__list-item' or role='alert']")).getText();
        String expectedText = "Invalid email or password.";
        Assert.assertEquals("verify text", expectedText, actualtext);

    }
    @After
    public void tearDown (){
        closeBrowser();

    }


     }



