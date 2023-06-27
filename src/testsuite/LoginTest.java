package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

//        click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
//         Verify the text ‘Welcome Back!’
        String expectedMessage = "Welcome Back!";
        String actualMessage = driver.findElement(By.xpath("//h2[@class = 'page__heading']")).getText();
        Assert.assertEquals("Welcome Back! is not displayed", expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheErrorMessage() {

//        click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
//        Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("Poonam123@gmail.com");
//         Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("Poonam");
//         Click on Login button
        driver.findElement(By.xpath("//button[@class = 'button button-primary g-recaptcha']")).click();
//         Verify the error message ‘Invalid email or password.’
        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Error Message is not displayed", expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
