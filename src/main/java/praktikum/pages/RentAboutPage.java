package praktikum.pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

public class RentAboutPage {
    private final WebDriver driver;
    private static final By WHEN_DELIVER_FIELD = By.xpath(".//div[2]/div[1]/div/div/input");
    //календарь
    private static final By CALENDAR_WINDOW =By.className("react-datepicker__month-container");
    private static final By DATA_CALENDAR =By.className("react-datepicker__day--018");
    //выбор срока аренды
    private static final By RENTAL_PERIOD_FIELD =By.className("Dropdown-control");
    private static final By RENTAL_PERIOD_WINDOW =By.className("Dropdown-menu");
    private static final By RENTAL_PERIOD_WINDOW_LINE = By.xpath(".//div[2]/div[2]/div[2]/div[2]");
    // цвет самоката
    private static final By SCOOTER_COLOR = By.xpath(".//div[2]/div[3]/label[1]");
    // комментарий
    private static final By COMMENTARY_RENT_ABOUT_PAGE = By.xpath(".//div[2]/div[2]/div[4]/input");
    //кнопка закать
    private static final By BUTTON_ORDER_RENT_ABOUT_PAGE = By.xpath(".//div[2]/div[3]/button[2]");
    //окно оформления заказа
    private static final By PLACE_ORDER_WINDOW = By.className("Order_ModalHeader__3FDaJ");
    private static final By YES_BUTTON_PLACE_ORDER_WINDOW =By.xpath(".//div[5]/div[2]/button[2]");
    // окно с номером заказа
    private static final By WINDOW_WITH_ORDER_NUMBER = By.className("Order_NextButton__1_rCA");
    private static final By TEXT_ORDER_PLACEMENT = By.className("Order_ModalHeader__3FDaJ");
    private static final String CHECK_ORDER_PLACEMENT = "Заказ оформлен";

    public RentAboutPage(WebDriver driver) {
        this.driver = driver;
    }

    public RentAboutPage enterWhenDeliver (){
       driver.findElement(WHEN_DELIVER_FIELD).click();
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.visibilityOfElementLocated(CALENDAR_WINDOW));
       driver.findElement(DATA_CALENDAR).click();
       return  this;
   }

    public RentAboutPage clickRentalPeriod (){
       driver.findElement(RENTAL_PERIOD_FIELD).click();
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.visibilityOfElementLocated(RENTAL_PERIOD_WINDOW));
       driver.findElement(RENTAL_PERIOD_WINDOW_LINE).click();
       return this;
   }

    public RentAboutPage clickScooterColor() {
        driver.findElement(SCOOTER_COLOR).click();
        return this;
    }

    public RentAboutPage enterCommentaryRentAboutPage(){
        driver.findElement(COMMENTARY_RENT_ABOUT_PAGE).sendKeys("позвонить за 30 минут.");
        return this;
    }

   public RentAboutPage clickOrderButton(){
       driver.findElement(BUTTON_ORDER_RENT_ABOUT_PAGE).click();
       return this;
   }

   public RentAboutPage orderFormationWindow (){
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.visibilityOfElementLocated(PLACE_ORDER_WINDOW));
       driver.findElement(YES_BUTTON_PLACE_ORDER_WINDOW).click();
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.elementToBeClickable(WINDOW_WITH_ORDER_NUMBER));
       return this;
   }

    public RentAboutPage checkOrderPlacement(){
        String checkInterfaceOrderPlacement = driver.findElement(TEXT_ORDER_PLACEMENT).getText();
        MatcherAssert.assertThat(checkInterfaceOrderPlacement,containsString(CHECK_ORDER_PLACEMENT));
        return this;
    }
}
