package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class WhoseScooterPage {
    private final WebDriver driver;
    public WhoseScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле Имя
    public final By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    //Поле Фамилия
    protected final By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле Адрес
    protected final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле Станция метро
    protected final By metroInput = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле Телефон
    protected final By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    protected final By nextScooterButton = By.className("Button_Middle__1CSJM");


        //Метод ввода имени
     public void fillNameWScooter(String name) {
        assertTrue(driver.findElement(nameInput).isEnabled());
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }
        //Метод ввода фамилии
    public void fillLastNameWScooter(String lastName) {
        assertTrue(driver.findElement(lastNameInput).isEnabled());
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
        }
        //Метод ввода адреса
    public void fillAddressWScooter(String address) {
        assertTrue(driver.findElement(addressInput).isEnabled());
        driver.findElement(addressInput).clear();
        driver.findElement(addressInput).sendKeys(address);
    }
        //Метода выбора метро
    public void choiceSubwey(int numberStation) {
        assertTrue(driver.findElement(metroInput).isEnabled());
        driver.findElement(metroInput).clear();
        driver.findElement(metroInput).click();
        //Выбор станции метро по номеру в списке
        driver.findElement(By.xpath(".//ul[@class='select-search__options']/li["+ numberStation +"]")).click();
    }

        //Метод ввода телефона
    public void fillPhoneWScooter(String phone){
        assertTrue(driver.findElement(phoneInput).isEnabled());
        driver.findElement(phoneInput).clear();
        driver.findElement(phoneInput).sendKeys(phone);
    }

       //Метод клика на кнопку Далее
    public void clickNextButtonWScooter(){
        assertTrue(driver.findElement(nextScooterButton).isEnabled());
        driver.findElement(nextScooterButton).click();
    }

    //Метод ввода данных в форму
    public void fillFormScooter(String name, String lastName, String address, int numberStation, String phone) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        fillNameWScooter(name);
        fillLastNameWScooter(lastName);
        fillAddressWScooter(address);
        choiceSubwey(numberStation);
        fillPhoneWScooter(phone);
        clickNextButtonWScooter();
    }


    }
