import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Digest_Auth_Test {
@Test
    public void verifyDigestAuth(){
        WebDriver driver;
        String url="https://the-internet.herokuapp.com/";
        String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get(url);
        driver.findElement(By.linkText("Digest Authentication")).click();
        String authUrl = "https://" + "admin" + ":" + "admin"+ "@the-internet.herokuapp.com/digest_auth";
        // Navigate to the URL with authentication credentials
        driver.get(authUrl);
        String actualHeader= driver.findElement(By.tagName("h3")).getText();
        String expectedHeader="Digest Auth";
        Assert.assertEquals(actualHeader,expectedHeader);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"Congratulations! You must have the proper credentials.");




    }
}
