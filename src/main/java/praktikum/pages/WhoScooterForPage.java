package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WhoScooterForPage {
    //заголовок для кого самокат
    protected static final By WHO_SCOOTER_FOR = By.className("Order_Header__BZXOb");
    private static final By NAME_FIELD =By.xpath(".//div[2]/div[1]/input");
    private static final By SURNAME_FIELD = By.xpath(".//div[2]/div[2]/input");
    private static final By ADDRESS_FIELD = By.xpath(".//div[2]/div[3]/input");
    private static final By METRO_STATION_FIELD = By.xpath(".//div/div[2]/div[2]/div[4]/div/div/input");
    private static final By STATION_LIST = By.cssSelector("[data-index= '0']");
    private static final By PHONE_NUMBER_FIELD = By.xpath(".//div[2]/div[5]/input");
    //кнопка далее
    private static final By FURTHER_BUTTON = By.xpath(".//div/div[2]/div[3]/button");
    private final WebDriver driver;

    public WhoScooterForPage(WebDriver driver) {
                this.driver = driver;
    }

    public WhoScooterForPage enterNameField (String nameFieldUser){
        driver.findElement(NAME_FIELD).sendKeys(nameFieldUser);
        return this;
    }
    public WhoScooterForPage enterSurnameField (String surnameFieldUser){
        driver.findElement(SURNAME_FIELD).sendKeys(surnameFieldUser);
        return this;
    }
    public WhoScooterForPage enterAddressField (String addressFieldUser){
        driver.findElement(ADDRESS_FIELD).sendKeys(addressFieldUser);
        return this;
    }
    public WhoScooterForPage enterMetroStationField (){
        driver.findElement(METRO_STATION_FIELD).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(STATION_LIST));
        driver.findElement(STATION_LIST).click();
        return this;
    }
    public WhoScooterForPage enterPhoneNumberField(String phoneNumberFieldUser){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(PHONE_NUMBER_FIELD));
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNumberFieldUser);
        return this;
    }

    public WhoScooterForPage clickFurtherButton (){
        new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(FURTHER_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
        return this;
    }

}
