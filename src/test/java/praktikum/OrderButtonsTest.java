package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;
import praktikum.pages.RentAboutPage;
import praktikum.pages.WhoScooterForPage;

@RunWith(Parameterized.class)
public class OrderButtonsTest {
    private WebDriver driver;
    //переменные для тестов
    private final String nameFieldUser;
    private final String surnameFieldUser;
    private final String addressFieldUser;
    private final String phoneNumberFieldUser;

    public OrderButtonsTest(String nameFieldUser, String surnameFieldUser, String addressFieldUser,
                             String phoneNumberFieldUser) {
        this.nameFieldUser = nameFieldUser;
        this.surnameFieldUser = surnameFieldUser;
        this.addressFieldUser = addressFieldUser;
        this.phoneNumberFieldUser = phoneNumberFieldUser;
    }

    @Before
    public void startWork (){
        DriverFactory driverFactory = new DriverFactory();
        if ("firefox".equals(System.getProperty("browser"))){
            driver = driverFactory.startFirefox();
        } else {
            driver = driverFactory.startChrome();
        }
    }

    @Parameterized.Parameters
    public static Object[][] orderButtonsCheck() {
        return new Object[][] {
                {"Иннокентий", "Васильев", "Москва",  "+79990008877"} ,
                {"Анна Мария", "Вас", "улица Новомосковская, д. 5", "89997770000"}
        };
    }

    @Test
    public void clickOrderButtonHeader() {
        MainPage mainPage = new MainPage(driver, "", "");

        WhoScooterForPage whoScooterForPage = new WhoScooterForPage(driver);
        mainPage.clickOrderButtonHeader();
        whoScooterForPage.enterNameField(nameFieldUser)
                .enterSurnameField(surnameFieldUser)
                .enterAddressField(addressFieldUser)
                .enterMetroStationField()
                .enterPhoneNumberField(phoneNumberFieldUser)
                .clickFurtherButton();

        RentAboutPage rentAboutPage = new RentAboutPage(driver);
        rentAboutPage.enterWhenDeliver()
                .clickRentalPeriod()
                .clickScooterColor()
                .enterCommentaryRentAboutPage()
                .clickOrderButton()
                .orderFormationWindow()
                .checkOrderPlacement();
    }

    @Test
    public void clickOrderButtonBody() {
        MainPage mainPage = new MainPage(driver,"","");
        WhoScooterForPage whoScooterForPage = new WhoScooterForPage(driver);
        mainPage.clickOrderButtonBody();
        whoScooterForPage.enterNameField(nameFieldUser)
                .enterSurnameField(surnameFieldUser)
                .enterAddressField(addressFieldUser)
                .enterMetroStationField()
                .enterPhoneNumberField(phoneNumberFieldUser)
                .clickFurtherButton();

        RentAboutPage rentAboutPage = new RentAboutPage(driver);
        rentAboutPage.enterWhenDeliver()
                .clickRentalPeriod()
                .clickScooterColor()
                .enterCommentaryRentAboutPage()
                .clickOrderButton()
                .orderFormationWindow()
                .checkOrderPlacement();
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}