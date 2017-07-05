import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestClass {

    private FirefoxDriver driver;
    private MainPage mainPage;
    private IPhone7Page iPhone7Page;


    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        iPhone7Page = new IPhone7Page(driver);
        driver.manage().window().maximize();

    }
    /*@After
    public void tearDown(){
        if (driver != null) {
            driver.close();
        }
    }*/
    @Test
    public void iPhone7Find(){
        mainPage.openUrl("http://hotline.ua");
        mainPage.enterSearchData("iPhone");
        mainPage.getExpectedResult("Apple iPhone 7");
        iPhone7Page.chooseAllPrices();
        iPhone7Page.getMinPrice(10, 6, 12);
    }

}
