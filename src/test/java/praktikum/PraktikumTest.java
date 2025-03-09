package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.AboutRentPage;
import praktikum.pages.MainPage;
import praktikum.pages.WhoseScooterPage;

public class PraktikumTest {
    //вызывает метод Before and After
    @Rule
    public praktikum.DriverRule factory = new praktikum.DriverRule();

    @Test
    public void openPage() throws Exception{
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        var whoseScooterPage = new WhoseScooterPage(driver);
        var aboutRent = new AboutRentPage(driver);

        mainPage.clickUpOrderButton();
        whoseScooterPage.fillFormScooter("Макс", "Латышев", "Ачишховская 11", 7,"+79001122333");
        //Дату вводить в формате Число, Месяц(обязательно текстом, с маленькой буквы, например "марта"), Год
        // полный пример 10 "марта" 2025. Пока работает пример с текущим месяцем и годом)
        aboutRent.whenBringScooter(10, "марта", 2025);
        //Количество суток максимум 7
        aboutRent.rentalPeriod(5);
        aboutRent.clickOrderNextButton();
        aboutRent.clickYesButton();
        aboutRent.orderPlacedFinal();

    }

}
