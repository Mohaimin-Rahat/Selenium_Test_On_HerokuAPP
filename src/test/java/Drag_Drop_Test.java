import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Drag_Drop_Test {

    @Test
    public void verifyDragDrop(){
        WebDriver driver;
        String url="https://the-internet.herokuapp.com/";
        String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get(url);
        driver.findElement(By.linkText("Drag and Drop")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"Drag and Drop");

        WebElement from=driver.findElement(By.xpath("//*[@id='column-a']"));
        WebElement to=driver.findElement(By.xpath("//*[@id='column-b']"));

        Actions act=new Actions(driver);
        //Dragged and dropped.
        act.dragAndDrop(from, to).build().perform();
        Assert.assertEquals(driver.findElement(By.tagName("header")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"column-b\"]/header")).getText(),"A");
    }
}
