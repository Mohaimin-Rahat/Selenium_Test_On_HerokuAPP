import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthTest {
    @Test
    public void verifyFormAuth(){
        WebDriver driver;
        String url="https://the-internet.herokuapp.com/";
        String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get(url);
        driver.findElement(By.linkText("Form Authentication")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Login Page");

        WebElement userName= driver.findElement(By.id("username"));
        WebElement pass= driver.findElement(By.id("password"));
        userName.sendKeys("tomsmith");
        pass.sendKeys("SuperSecretPassword!");

        driver.findElement(By.tagName("button")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Secure Area");
        driver.findElement(By.linkText("Logout")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Login Page");
    }
    @Test
    public void verifyWithNegativeUsernamePassword(){


            WebDriver driver;
            String url="https://the-internet.herokuapp.com/";
            String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/chromedriver";
            System.setProperty("webdriver.chrome.driver",driverPath);
            driver =new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            options.addArguments("--start-maximized");
            driver.get(url);
            driver.findElement(By.linkText("Form Authentication")).click();
            Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Login Page");

            WebElement userName= driver.findElement(By.id("username"));
            WebElement pass= driver.findElement(By.id("password"));
            userName.sendKeys("tomsmith");
            pass.sendKeys("tomsmith1234");

            driver.findElement(By.tagName("button")).click();
             Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Login Page");

        }

}


