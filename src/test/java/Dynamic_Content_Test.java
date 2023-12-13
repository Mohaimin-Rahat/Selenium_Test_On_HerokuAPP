import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dynamic_Content_Test {
    @Test
    public void verifyContentChanges(){
        WebDriver driver;
        String url="https://the-internet.herokuapp.com/";
        String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get(url);
        driver.findElement(By.linkText("Dynamic Content")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"Dynamic Content");

        String pageSourceBeforeReload = driver.getPageSource();
        driver.findElement(By.linkText("click here")).click();
        String pageSourceAfterReload = driver.getPageSource();

        Assert.assertNotSame(pageSourceBeforeReload,pageSourceAfterReload);

    }

}
