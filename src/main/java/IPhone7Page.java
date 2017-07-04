import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class IPhone7Page {

    private WebDriver driver;
    private List<WebElement> shopList;

    public IPhone7Page(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseAllPrices() {
        //Wait for element to be clickable and click it
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".range-price.orng.g_statistic")));
        driver.findElement(By.cssSelector(".range-price.orng.g_statistic")).click();
    }

    public void getMinPrice(int feedback, int warranty){
        //Wait for element appear
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("..box-line.flex-block.flex-stretch.cell")));
        //Add elements to the list
        shopList = driver.findElements(By.cssSelector(".box-line.flex-block.flex-stretch.cell"));
        //Print element count
        System.out.println("Shop list has " + shopList.size() + " items");

    }

}
