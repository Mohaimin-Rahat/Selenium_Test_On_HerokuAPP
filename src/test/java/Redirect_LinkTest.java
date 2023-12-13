import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Redirect_LinkTest {
    @Test
    public void verifyRedirectLink(){
        WebDriver driver;
        String url="https://the-internet.herokuapp.com/";
        String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get(url);
        driver.findElement(By.linkText("Redirect Link")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"Redirection");
        driver.findElement(By.linkText("here")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"Status Codes");

        driver.findElement(By.linkText("here")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"Hypertext Transfer Protocol (HTTP) Status Code Registry");
        driver.navigate().back();

        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"This page returned a 200 status code.\n" +
                "\nFor a definition and common list of HTTP status codes, go here");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"This page returned a 301 status code.\n" +
                "\nFor a definition and common list of HTTP status codes, go here");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"This page returned a 404 status code.\n" +
                "\nFor a definition and common list of HTTP status codes, go here");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"This page returned a 500 status code.\n" +
                "\nFor a definition and common list of HTTP status codes, go here");
        driver.findElement(By.linkText("here")).click();

    }
}
