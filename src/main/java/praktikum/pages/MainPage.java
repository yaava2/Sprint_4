package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class MainPage {
    private final WebDriver driver;
    //вопросы о важном
    private final String questionSelectorId;
    private final String answerSelectorId;
    private final String textQuestion;
    private final String textAnswer;
    // заказать
    private static final By orderButtonHeader = By.xpath(" .//div[2]/button[1]");
    private static final By orderButtonBody = By.xpath(".//div[4]/div[2]/div[5]/button");

    public MainPage(WebDriver driver, String questionSelectorId, String answerSelectorId, String textQuestion, String textAnswer) {
        this.driver = driver;
        this.questionSelectorId = questionSelectorId;
        this.answerSelectorId = answerSelectorId;
        this.textQuestion = textQuestion;
        this.textAnswer = textAnswer;
    }

    //кнопка заказать в шапке страницы
        public MainPage clickOrderButtonHeader (){

            System.out.println(driver.findElement(orderButtonHeader));
        driver.findElement(orderButtonHeader).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(WhoScooterForPage.whoScooterFor));
        return this;
    }
    //кнопка заказать в основной части страницы
    public MainPage clickOrderButtonBody (){
        System.out.println(driver.findElement(orderButtonBody));
        driver.findElement(orderButtonBody).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(WhoScooterForPage.whoScooterFor));
        return this;
    }

    //для вопросов о важном
    public MainPage foundQuestionSelectorId(){
        driver.findElement(By.id(questionSelectorId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(By.id(questionSelectorId)));
        return this;
    }

    public MainPage checkQuestionSelectorId (){
        String textInterfaceQuestion = driver.findElement(By.id(questionSelectorId)).getText();
        assertEquals(textInterfaceQuestion, textQuestion);
        return this;
    }

    public MainPage foundAnswerSelectorId(){
        driver.findElement(By.id(questionSelectorId)).click();
        return this;
    }

    public MainPage checkAnswerSelectorId(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(answerSelectorId)));
        String textInterfaceAnswer = driver.findElement(By.id(answerSelectorId)).getText();
        assertEquals(textInterfaceAnswer, textAnswer);
        return this;
    }
}
