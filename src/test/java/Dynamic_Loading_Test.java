import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dynamic_Loading_Test {
    @Test
    public void verifyDynamicLoading(){
        WebDriver driver;
        String url="https://the-internet.herokuapp.com/";
        String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get(url);
        driver.findElement(By.linkText("Dynamic Loading")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"Dynamically Loaded Page Elements");

        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(),"Example 1: Element on page that is hidden");
        driver.findElement(By.tagName("button")).click();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(),"Hello World!");

        //driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.navigate().back();

        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(),"Example 2: Element rendered after the fact");
        driver.findElement(By.tagName("button")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(),"Hello World!");




    }
}
