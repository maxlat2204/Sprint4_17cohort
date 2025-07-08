package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class QuestionPage {

    private final WebDriver driver;
    public QuestionPage(WebDriver driver) {
        this.driver = driver;
    }

    //1 Вопрос "Сколько это стоит? И как оплатить?"
    public final By question1 = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    //Раскрывающийся текст в Вопросе 1
    public final By questionText1 = By.xpath(".//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");

    //2 Вопрос "Хочу сразу несколько самокатов! Так можно?"
    public final By question2 = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    //Раскрывающийся текст в Вопросе 2
    public final By questionText2 = By.xpath(".//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");

    //3 Вопрос "Как рассчитывается время аренды?"
    public final By question3 = By.xpath(".//div[text()='Как рассчитывается время аренды?']");
    //Раскрывающийся текст в Вопросе 3
    public final By questionText3 = By.xpath(".//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");

    //4 Вопрос "Можно ли заказать самокат прямо на сегодня?"
    public final By question4 = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    //Раскрывающийся текст в Вопросе 4
    public final By questionText4 = By.xpath(".//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");

    //5 Вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    public final By question5 = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    //Раскрывающийся текст в Вопросе 5
    public final By questionText5 = By.xpath(".//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");

    //6 Вопрос "Вы привозите зарядку вместе с самокатом?"
    public final By question6 = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    //Раскрывающийся текст в Вопросе 6
    public final By questionText6 = By.xpath(".//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");

    //7 Вопрос "Можно ли отменить заказ?"
    public final By question7 = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    //Раскрывающийся текст в Вопросе 7
    public final By questionText7 = By.xpath(".//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");

    //8 Вопрос "Я жизу за МКАДом, привезёте?"
    public final By question8 = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");
    //Раскрывающийся текст в Вопросе 8
    public final By questionText8 = By.xpath(".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");


    //Метод получения текста вопроса
    public String checkTextQuestion(By question, By questionText){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(question));
        clickQuestion(question);
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(questionText));
        return getQuestionText(questionText);
    }

    //Метод получения текста и его возврат
    private String getQuestionText(By questionText) {
        assertTrue(driver.findElement(questionText).isDisplayed());
        return driver.findElement(questionText).getText();
    }

    //Метод клика по вопросу
    private void clickQuestion(By question) {
        assertTrue(driver.findElement(question).isEnabled());
        driver.findElement(question).click();
    }
}
