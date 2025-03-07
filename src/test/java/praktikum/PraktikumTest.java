package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PraktikumTest {
    //вызывает метод Before and After
    @Rule
    public praktikum.DriverRule factory = new praktikum.DriverRule();

    @Test
    public void openPage() throws Exception{
        WebDriver driver = factory.getDriver();
//        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

}
