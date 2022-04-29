package browserfactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class TestSuite extends Utility {

    String baseUrl = "https://www.amazon.co.uk/";

@Before
    public void setUp(){
    openBrowser(baseUrl);
}
@Test
    public void dellLaptop()  {

    //accept cookie
    clickOnElement(By.id("sp-cc-accept"));

    //Type "Dell Laptop" in the search box and press enter.
    sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");

    //click on search Button.
    clickOnElement(By.id("nav-search-submit-button"));

   //click on check box
    clickOnElement(By.xpath("//*[@id='p_89/Dell']/span/a/div/label/i"));

  //  WebElement productDell = driver.findElement(By.xpath("//div[@data-component-type='s-search-result']"));
    WebElement productDell = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
   // List<WebElement> list = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
    List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
    int countProduct = list.size();
   // System.out.println("Size of the list: " + countProduct);
    List<String > actualList = new ArrayList<>();
    for ( WebElement element : list){

        actualList.add(element.getText());

    }
    //product count
    if(productDell.isDisplayed()){
        Assert.assertEquals("Count no of product: ",countProduct,30);
        //print prodoct list
        System.out.println("Product Name:" + actualList);
    }
}
@After
public void tearDown(){
    closeBrowser();
}

}
