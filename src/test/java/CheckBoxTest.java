import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckBoxTest {
@Test
    public void  verifyCheckBox(){

        WebDriver driver;
        String url="https://the-internet.herokuapp.com/";
        String driverPath= System.getProperty("user.dir")+"/Drivers/CromeDriver/Google Chrome for Testing.app";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver =new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--start-maximized");
        driver.get(url);
        driver.findElement(By.linkText("Checkboxes")).click();
        String actualHeader= driver.findElement(By.tagName("h3")).getText();
        String expectedHeader="Checkboxes";
        Assert.assertEquals(actualHeader,expectedHeader);
        /*Checking the status of first checkbox*/
        boolean actualStatus = driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[1]")).isSelected();
        if (actualStatus==false){
            driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[1]")).click();
            System.out.println("First checkbox is selected");
        }
        else {
            System.out.println("First checkbox has been selected already");
        }
        /*Checking the status of second checkbox*/
        boolean actualStatusForSecondBox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected();
        if (actualStatusForSecondBox==false){
            driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
            System.out.println("Second checkbox is selected");
        }
        else {
            System.out.println("Second checkbox has been selected already");
        }
        driver.close();
    }
}
