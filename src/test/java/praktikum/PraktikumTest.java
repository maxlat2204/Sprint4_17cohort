package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import praktikum.pages.AboutRentPage;
import praktikum.pages.MainPage;
import praktikum.pages.WhoseScooterPage;

@RunWith(Parameterized.class)
public class PraktikumTest {

    //Элементы WhoseScooterPaje
    private final String name;
    private final String lastName;
    private final String address;
    private final int numberStation;
    private final String phone;
    //Элементы AboutRentPage
    private final int day;
    private final String month;
    private final int year;
    private final int howDays;

    public PraktikumTest(String name, String lastName, String address, int numberStation, String phone, int day, String month, int year, int howDays) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.numberStation = numberStation;
        this.phone = phone;
        this.day = day;
        this.month = month;
        this.year = year;
        this.howDays = howDays;
    }

    @Parameterized.Parameters(name = "name = {0}, lastName = {1}, address = {2}, numberStation = {3},phone = {4},day = {5},month = {6},year = {7},howDays = {8}")
    public static Object[][] data(){
        return new Object[][]{
                {"Макс", "Латышев", "Ачишховская 11", 7, "+79001122333", 10, "марта", 2025, 5},
                {"Владимир", "Ленин", "Советов 12", 2, "+79001122444", 11, "марта", 2025, 3}
        };
    }

    @Rule
    public praktikum.DriverRule factory = new praktikum.DriverRule();

    @Test
    //Проверка через верхнюю кнопку Заказать
    public void upButtonCeckOrderScooterUpButton() throws Exception{
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        var whoseScooterPage = new WhoseScooterPage(driver);
        var aboutRent = new AboutRentPage(driver);

        mainPage.clickUpOrderButton();
        whoseScooterPage.fillFormScooter(name, lastName, address, numberStation,phone);
        //Дату вводить в формате Число, Месяц(обязательно текстом, с маленькой буквы, например "марта"), Год
        // полный пример 10 "марта" 2025. Пока работает пример с текущим месяцем и годом)
        aboutRent.whenBringScooter(day, month, year);
        //Количество суток максимум 7
        aboutRent.rentalPeriod(howDays);
        aboutRent.clickOrderNextButton();
        aboutRent.clickYesButton();
        aboutRent.orderPlacedFinal();

    }

    @Test
    //Проверка через нижнюю кнопку Заказать
    public void downButtonCeckOrderScooterDownButton() throws Exception{
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        var whoseScooterPage = new WhoseScooterPage(driver);
        var aboutRent = new AboutRentPage(driver);

        mainPage.clickDownOrderButton();
        whoseScooterPage.fillFormScooter(name, lastName, address, numberStation,phone);
        //Дату вводить в формате Число, Месяц(обязательно текстом, с маленькой буквы, например "марта"), Год
        // полный пример 10 "марта" 2025. Пока работает пример с текущим месяцем и годом)
        aboutRent.whenBringScooter(day, month, year);
        //Количество суток максимум 7
        aboutRent.rentalPeriod(howDays);
        aboutRent.clickOrderNextButton();
        aboutRent.clickYesButton();
        aboutRent.orderPlacedFinal();
    }

}
