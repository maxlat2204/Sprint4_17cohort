package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //Верхняя кнопка заказать
    protected final By upOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Нижняя кнопка Заказать
    protected final By downOrderButton = By.className("Button_Middle__1CSJM");
    //Кнопка Статус Заказа
    protected final By statusOrderButton = By.className("Header_Link__1TAG7");
    //Кнопка Go! в статусе заказа
    protected final By goButton = By.className("Header_Button__28dPO");
    //Поле ввода Заказа
    protected final By orderFieldInput = By.className("Input_Input__1iN_Z ");
    //Кнопка самокат в Шапке
    protected final By scooterButton = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']/img[@alt='Scooter']");
    //Кнопка Яндекс в шапке
    protected final By yandexBuuton = By.xpath(".//img[@alt='Yandex']");


    //Метод нажатия на верхнюю кнопку Заказать
    public void clickUpOrderButton(){
        driver.findElement(upOrderButton).click();
    }
    //Метод Нажатия на нижнюю кнопку Заказать
    public void clickDownOrderButton(){
        driver.findElement(downOrderButton).click();
    }


}
