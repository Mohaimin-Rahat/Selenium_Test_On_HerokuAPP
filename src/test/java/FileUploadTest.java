import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest {
    @Test
    public void verifyFileUpload(){
        WebDriver driver;
        String url="https://the-internet.herokuapp.com/";
        String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get(url);
        driver.findElement(By.linkText("File Upload")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"File Uploader");

        WebElement uploadElement=driver.findElement(By.id("file-upload"));
        uploadElement.sendKeys("/Users/rahat/Downloads/Pic/R.JPG");
        driver.findElement(By.id("file-submit")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"File Uploaded!");
    }
    @Test
    public void negativeTest(){
        WebDriver driver;
        String url="https://the-internet.herokuapp.com/";
        String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get(url);
        driver.findElement(By.linkText("File Upload")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"File Uploader");

        driver.findElement(By.id("file-submit")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"Internal Server Error");
    }
}
