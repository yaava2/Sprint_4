package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class MainPage {
    private final WebDriver driver;
    //вопросы о важном
    private final String textQuestion;
    private final String textAnswer;
    // кнопки заказать
    private static final By ORDER_BUTTON_HEADER = By.xpath(" .//div[2]/button[1]");
    private static final By ORDER_BUTTON_BODY = By.xpath(".//div[4]/div[2]/div[5]/button");

    private final By questionSelector;
    private final By answerSelector;

    public MainPage(WebDriver driver, String textQuestion, String textAnswer) {
        this.driver = driver;
        this.textQuestion = textQuestion;
        this.textAnswer = textAnswer;

        questionSelector = By.xpath(".//div[text()='"+textQuestion+"']");
        answerSelector = By.xpath(".//p[text()='"+textAnswer+"']");
    }

    //кнопка заказать в шапке страницы
        public MainPage clickOrderButtonHeader (){
        driver.findElement(ORDER_BUTTON_HEADER).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(WhoScooterForPage.WHO_SCOOTER_FOR));
        return this;
    }
    //кнопка заказать в основной части страницы
    public MainPage clickOrderButtonBody (){
        driver.findElement(ORDER_BUTTON_BODY).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(WhoScooterForPage.WHO_SCOOTER_FOR));
        return this;
    }

    //для вопросов о важном
    public MainPage foundQuestionSelector(){
        driver.findElement(questionSelector);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(questionSelector));
        return this;
    }

    public MainPage checkQuestionSelector (){
        String textInterfaceQuestion = driver.findElement(questionSelector).getText();
        assertEquals(textInterfaceQuestion, textQuestion);
        return this;
    }

    public MainPage foundAnswerSelector(){
        driver.findElement(questionSelector).click();
        return this;
    }

    public MainPage checkAnswerSelector(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(answerSelector));
        String textInterfaceAnswer = driver.findElement(answerSelector).getText();
        assertEquals(textInterfaceAnswer, textAnswer);
        return this;
    }
}
