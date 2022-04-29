package browserfactory;

import com.sun.org.apache.bcel.internal.classfile.Utility;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest  {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){

        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(baseUrl);
        //maximise window
        driver.manage().window().maximize();
        //implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //get title
        String title = driver.getTitle();
        System.out.println("Title: " + title);

    }
    public void closeBrowser(){

        driver.quit();
    }

}
