package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class AboutRentPage {
    private final WebDriver driver;

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле когда привезти самокат
    public final By whenBringScooterInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле срок аренды
    public final By rentalPeriodInput = By.className("Dropdown-placeholder");
    //Кнопка заказать
    public final By orderNextButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //Метод выбор когда привезти самокат
    public void whenBringScooter(int day, String month, int year){
        assertTrue(driver.findElement(whenBringScooterInput).isEnabled());
        driver.findElement(whenBringScooterInput).clear();
        driver.findElement(whenBringScooterInput).click();
        //Выбор даты
        driver.findElement(By.xpath(".//div[contains(@aria-label,'"+day+"-е "+month+" "+year+"')]")).click();
    }

    //Метод выбора срока аренды
    public void rentalPeriod(int howDays){
        assertTrue(driver.findElement(rentalPeriodInput).isEnabled());
        driver.findElement(rentalPeriodInput).click();
        //Выбор срока
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div["+howDays+"]")).click();

    }
    //Метод клика по кнопке заказать
    public void clickOrderNextButton(){
        assertTrue(driver.findElement(orderNextButton).isEnabled());
        driver.findElement(orderNextButton).click();
    }


    //ОКНО ХОТИТЕ ОФОРМИТЬ ЗАКАЗ
    //кнопка Да
    public final By yesButton = By.xpath(".//button[text()='Да']");

    //Метод нажатия на кнопку да в окне Хотите оформить Заказ
    public void clickYesButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        assertTrue(driver.findElement(yesButton).isEnabled());
        driver.findElement(yesButton).click();
    }

    //Окно заказ оформлен
    public final By orderPlaced = By.className("Order_ModalHeader__3FDaJ");

    //Метод потверждения заказа Финал
    public void orderPlacedFinal() {
        assertTrue("Заказ не оформлен",driver.findElement(orderPlaced).isDisplayed());
    }





}
