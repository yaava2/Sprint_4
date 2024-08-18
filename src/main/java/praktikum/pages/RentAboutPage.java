package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RentAboutPage {
    private final WebDriver driver;
    private static final By WhenDeliverField = By.xpath(".//div[2]/div[1]/div/div/input");
    //календарь
    private static final By calendarWindow =By.className("react-datepicker__month-container");
    private static final By dataCalendar =By.className("react-datepicker__day--018");
    //выбор срока аренды
    private static final By RentalPeriodField =By.className("Dropdown-control");
    private static final By RentalPeriodWindow =By.className("Dropdown-menu");
    private static final By RentalPeriodWindowLine= By.xpath(".//div[2]/div[2]/div[2]/div[2]");
    // цвет самоката
    private static final By scooterColor = By.xpath(".//div[2]/div[3]/label[1]");
    // комментарий
    private static final By CommentaryRentAboutPage = By.xpath(".//div[2]/div[2]/div[4]/input");
    //кнопка закать
    private static final By ButtonOrderRentAboutPage= By.xpath(".//div[2]/div[3]/button[2]");
    //окно оформления заказа
    private static final By placeOrderWindow = By.className("Order_ModalHeader__3FDaJ");
    private static final By yesButtonPlaceOrderWindow =By.xpath(".//div[5]/div[2]/button[2]");
    // окно с номером заказа
    private static final By WindowWithOrderNumber = By.className("Order_NextButton__1_rCA");

    public RentAboutPage(WebDriver driver) {
        this.driver = driver;
    }

    public RentAboutPage enterWhenDeliver (){
       driver.findElement(WhenDeliverField).click();
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.visibilityOfElementLocated(calendarWindow));
       driver.findElement(dataCalendar).click();
       return  this;
   }

    public RentAboutPage clickRentalPeriod (){
       driver.findElement(RentalPeriodField).click();
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.visibilityOfElementLocated(RentalPeriodWindow));
       driver.findElement(RentalPeriodWindowLine).click();
       return this;
   }

    public RentAboutPage clickScooterColor() {
        driver.findElement(scooterColor).click();
        return this;
    }

    public RentAboutPage enterCommentaryRentAboutPage(){
        driver.findElement(CommentaryRentAboutPage).sendKeys("позвонить за 30 минут.");
        return this;
    }

   public RentAboutPage clickOrderButton(){
       driver.findElement(ButtonOrderRentAboutPage).click();
       return this;
   }

   public RentAboutPage orderFormationWindow (){
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.visibilityOfElementLocated(placeOrderWindow));
       driver.findElement(yesButtonPlaceOrderWindow).click();
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.elementToBeClickable(WindowWithOrderNumber));
       return this;
   }

}
