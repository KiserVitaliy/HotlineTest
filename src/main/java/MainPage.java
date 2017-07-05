import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;



public class MainPage {

    private WebDriver driver;
    private List<WebElement> iPhones;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url) { driver.get(url); }

    public void enterSearchData(CharSequence search){
        driver.findElement(By.cssSelector("#searchbox")).click();
        driver.findElement(By.cssSelector("#searchbox")).sendKeys(search);
    }

    public void getExpectedResult(CharSequence expectedResult){
        //Wait for auto-search appears
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='ui-menu-item']")));
        //Add elements to the list
        iPhones = driver.findElements(By.xpath("//*[@class='ui-menu-item']"));
        //Print count of found items
        System.out.println("Found " + iPhones.size() + " items.");
        //Find expectedResult in the list
        for (WebElement element : iPhones) {
            //Choose found result
            if ((element.getText().contains(expectedResult))) {
                System.out.println("Item: " + element.getText() + " is selected.");
                element.click();
                break;
            }
        }
    }
}
