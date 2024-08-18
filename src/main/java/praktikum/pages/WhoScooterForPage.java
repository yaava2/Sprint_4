package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WhoScooterForPage {
    //заголовок для кого самокат
    protected static final By whoScooterFor= By.className("Order_Header__BZXOb");
    private static final By nameField =By.xpath(".//div[2]/div[1]/input");
    private static final By surnameField = By.xpath(".//div[2]/div[2]/input");
    private static final By addressField = By.xpath(".//div[2]/div[3]/input");
    private static final By metroStationField = By.xpath(".//div/div[2]/div[2]/div[4]/div/div/input");
    private static final By stationList = By.cssSelector("[data-index= '0']");
    private static final By phoneNumberField = By.xpath(".//div[2]/div[5]/input");
    //кнопка далее
    private static final By furtherButton = By.xpath(".//div/div[2]/div[3]/button");
    private final WebDriver driver;

    public WhoScooterForPage(WebDriver driver) {
                this.driver = driver;
    }

    public WhoScooterForPage enterNameField (String nameFieldUser){
        driver.findElement(nameField).sendKeys(nameFieldUser);
        return this;
    }
    public WhoScooterForPage enterSurnameField (String surnameFieldUser){
        driver.findElement(surnameField).sendKeys(surnameFieldUser);
        return this;
    }
    public WhoScooterForPage enterAddressField (String addressFieldUser){
        driver.findElement(addressField).sendKeys(addressFieldUser);
        return this;
    }
    public WhoScooterForPage enterMetroStationField (){
        driver.findElement(metroStationField).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(stationList));
        driver.findElement(stationList).click();
        return this;
    }
    public WhoScooterForPage enterPhoneNumberField(String phoneNumberFieldUser){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(phoneNumberField));
        driver.findElement(phoneNumberField).sendKeys(phoneNumberFieldUser);
        return this;
    }

    public WhoScooterForPage clickFurtherButton (){
        new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(furtherButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
        return this;
    }

}
