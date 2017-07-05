import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class IPhone7Page {

    private WebDriver driver;
    private WebDriverWait wait;
    private List<WebElement> shopList;

    public IPhone7Page(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseAllPrices() {
        //Wait for element to be clickable and click it
        wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".range-price.orng.g_statistic")));
        driver.findElement(By.cssSelector(".range-price.orng.g_statistic")).click();
    }

    public void getMinPrice(int feedback, int warrantyFrom, int warrantyTo){
        //Wait for element appear
        wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".box-line.flex-block.flex-stretch.cell")));
        //Sort prices
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gotoshop-price")));
        driver.findElement(By.xpath("//a[@class='text-14' and contains(., 'Цена, грн')]")).click();
        System.out.println("Prices sorted");
        //Add elements to the list
        shopList = driver.findElements(By.cssSelector(".box-line.flex-block.flex-stretch.cell"));
        //Print shops count
        System.out.println("Shop list has " + shopList.size() + " items");
        //Find minimal price
        for (int i=1; i<=shopList.size(); i++) {
            /*//Get number of feedback
            System.out.println("Start to parse feedbacks");
            int fb = Integer.parseInt(shopList.get(i-1).findElement(By.cssSelector(".sum.g_statistic")).getText().substring(10,12));
            System.out.println("Finish to parse feedbacks");*/
            //Get min price
            if (shopList.get(i-1).findElement(By.xpath("//div[@class='flex-block cell7 cell6-980 cell7-768 flex-row-1024-b cell-500']/div[@class='delivery-th cell4 cell-1024-b p-10-0-1024-b' and contains(., '" + warrantyFrom + " мес') or contains(., '" + warrantyTo + " мес')]")).isDisplayed()) {
                    shopList.get(i-1).findElement(By.cssSelector("#gotoshop-price")).click();
                    System.out.println("Go to shop");
                    break;

            }
        }
    }

}
