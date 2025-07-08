package praktikum;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.pages.QuestionPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionTest{

    //Сделали чтобы браузер открылся один раз и провел все тесты
    @ClassRule
    public static praktikum.DriverRule factory = new praktikum.DriverRule();


    private final String expectedText;
    private final By question;
    private final By questionText;

    public QuestionTest(String expectedText, By question, By questionText) {
        this.expectedText = expectedText;
        this.question = question;
        this.questionText = questionText;
    }

    @Parameterized.Parameters(name = "expectedText = {0}, question = {1}, questionText = {2}")
    public static Object[][] data(){
        praktikum.DriverRule factory = new praktikum.DriverRule();
        WebDriver driver = factory.getDriver();
        var questionPage = new QuestionPage(driver);
        //Переменные с Ожидаемым текстом
        String expectedTextQuestion1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String expectedTextQuestion2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String expectedTextQuestion3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String expectedTextQuestion4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String expectedTextQuestion5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String expectedTextQuestion6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String expectedTextQuestion7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String expectedTextQuestion8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        return new Object[][]{
                {expectedTextQuestion1, questionPage.question1, questionPage.questionText1},
                {expectedTextQuestion2, questionPage.question2, questionPage.questionText2},
                {expectedTextQuestion3, questionPage.question3, questionPage.questionText3},
                {expectedTextQuestion4, questionPage.question4, questionPage.questionText4},
                {expectedTextQuestion5, questionPage.question5, questionPage.questionText5},
                {expectedTextQuestion6, questionPage.question6, questionPage.questionText6},
                {expectedTextQuestion7, questionPage.question7, questionPage.questionText7},
                {expectedTextQuestion8, questionPage.question8, questionPage.questionText8}
        };
    }


    @Test
    //Проверка совпадает ли текст требований с фактическим
    public void checText1() throws Exception {
        WebDriver driver = factory.getDriver();
        var questionPage = new QuestionPage(driver);
        //Сравниваем ОР и ФР
        assertEquals(expectedText, questionPage.checkTextQuestion(question, questionText));
    }
}