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
    private List<WebElement> warrantyList;

    public IPhone7Page(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseAllPrices() {
        //Wait for element to be clickable and click it
        wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".range-price.orng.g_statistic")));
        driver.findElement(By.cssSelector(".range-price.orng.g_statistic")).click();
        System.out.println("Go to prices.");
    }

    public void getMinPrice(int feedback, CharSequence warrantyFrom, int warrantyTo){
        //Wait for element appear
        wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".box-line.flex-block.flex-stretch.cell")));
        //Sort prices
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gotoshop-price")));
        driver.findElement(By.xpath("//a[@class='text-14' and contains(., 'Цена, грн')]")).click();
        System.out.println("Prices sorted");
        //Add elements to the list
        shopList = driver.findElements(By.xpath("//div[@class='delivery-th cell4 cell-1024-b p-10-0-1024-b' and contains(., '6 мес')]"));
        //Print shops count
        System.out.println("Shop list has " + shopList.size() + " items");
        System.out.println(shopList.get(0).getText());
        //Find minimal price
        for (WebElement element : shopList) {
            System.out.println(element.getText());
            /*//Get number of feedback
            System.out.println("Start to parse feedbacks");
            int fb = Integer.parseInt(shopList.get(i-1).findElement(By.cssSelector(".sum.g_statistic")).getText().substring(10,12));
            System.out.println("Finish to parse feedbacks");*/
            //Get min price
            // shopList.get(i-1).findElement(By.xpath("//div[@class='flex-block cell7 cell6-980 cell7-768 flex-row-1024-b cell-500']/div[@class='delivery-th cell4 cell-1024-b p-10-0-1024-b' and contains(., '" + warrantyFrom + " мес') or contains(., '" + warrantyTo + " мес')]"));
            //System.out.println(shopList.get(i-1).findElement(By.xpath("//a[@class='sum g_statistic']")).getText());
            System.out.println(element.findElement(By.xpath("//a[@class='sum g_statistic']")).getText());

            //shopList.get(i-1).findElement(By.xpath("//div[@class='delivery-th cell4 cell-1024-b p-10-0-1024-b' and contains(., '" + warrantyFrom + " мес')] | //div[@class='delivery-th cell4 cell-1024-b p-10-0-1024-b' and contains(., '" + warrantyTo + " мес')]"));
            if (element.findElement(By.xpath("//div[@class='delivery-th cell4 cell-1024-b p-10-0-1024-b']")).getText().contains("6 меc")) {
                System.out.println(element.findElement(By.xpath("//a[@class='sum g_statistic']")).getText() + " _new_ ");
                element.findElement(By.xpath("//*[@id='gotoshop-price']")).click();
                System.out.println("Go to shop");
                break;
            }



        }
    }

}
