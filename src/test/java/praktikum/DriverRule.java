package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverRule extends ExternalResource {
    private WebDriver driver;

    //Метод Before
    @Override
    protected void before() throws Throwable {
        initDriver();//открывает браузер
        driver.get(EnvConfig.BASE_URL);//открывает страницу
        closeСookies();//закрывает куки
    }

    //Метод After(закрывает браузер)
    @Override
    protected void after() {
        driver.quit();
    }

    //Запуск через firefox описан в файле readme.md
    public void initDriver() throws Exception{
        if ("firefox".equalsIgnoreCase(System.getProperty("browser"))){
            startBrowserFirefox();
        } else {
            startBrowserChrome();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

//    Открывает браузер Chrome
    public void startBrowserChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvConfig.IMLICIT_WAIT));
    }

    //Открывает браузер Firefox
    public void startBrowserFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvConfig.IMLICIT_WAIT));
    }

    //Закрывает куки
    public void closeСookies(){
        By coockiesCloseButton = By.id("rcc-confirm-button");
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(coockiesCloseButton));
        driver.findElement(coockiesCloseButton).click();
    }
}