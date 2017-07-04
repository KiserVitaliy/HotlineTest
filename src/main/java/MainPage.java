import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;



public class MainPage {

    private WebDriver driver;
    private List<WebElement> iPhones;
    private CharSequence search;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url){
        driver.get(url);
    }

    public void enterSearchData(CharSequence search){
        this.search = search;
        driver.findElement(By.cssSelector("#searchbox")).click();
        driver.findElement(By.cssSelector("#searchbox")).sendKeys(search);
    }

    public void getExpectedResult(CharSequence expectedResult){
        //Wait for auto-search appears
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/a[contains(text(), 'Apple')]")));
        //Add elements to the list
        iPhones = driver.findElements(By.xpath("//li/a[contains(text(), 'Apple')]"));
        //Print count of found items
        System.out.println("Found " + iPhones.size() + " iPhones");
        //Find expectedResult in the list
        for (int i=1; i<=iPhones.size(); i++) {
            //Choose found result
            if ((iPhones.get(i-1).getText().contains(expectedResult))) {
                System.out.println(iPhones.get(i-1).getText());
                iPhones.get(i-1).click();
            }
        }
    }


}
