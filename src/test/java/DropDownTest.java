import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {
    @Test
    public void verifyDropDown(){
        WebDriver driver;
        String url="https://the-internet.herokuapp.com/";
        String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get(url);
        driver.findElement(By.linkText("Dropdown")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"Dropdown List");

        Select dropDown= new Select(driver.findElement(By.tagName("select")));
        dropDown.selectByVisibleText("Option 1");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]")).getText(),"Option 1");

        Select dropDown2= new Select(driver.findElement(By.tagName("select")));
        dropDown2.selectByVisibleText("Option 2");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).getText(),"Option 2");

    }
}
