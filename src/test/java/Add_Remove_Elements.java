import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add_Remove_Elements {
@Test
    public void verifyAddRemove(){
        WebDriver driver;
        String url="https://the-internet.herokuapp.com/";
        String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get(url);
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        String actualHeader= driver.findElement(By.tagName("h3")).getText();
        String expectedHeader="Add/Remove Elements";
        Assert.assertEquals(actualHeader,expectedHeader);

        String actualValue= driver.findElement(By.tagName("button")).getText();
        String expectedValue="Add Element";
        Assert.assertEquals(actualValue,expectedValue);

        driver.findElement(By.tagName("button")).click();
        //driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
        driver.findElement(By.className("added-manually"));

        String actualText= driver.findElement(By.className("added-manually")).getText();
        String expectedText="Delete";
        Assert.assertEquals(actualText,expectedText);
    }
}
