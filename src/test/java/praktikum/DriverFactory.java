package praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static praktikum.EnvConfig.BASE_URL;

public class DriverFactory {

    public ChromeDriver startChrome(){
        ChromeDriver driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        return driver;
    }

    public FirefoxDriver startFirefox(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get(BASE_URL);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        return driver;
    }
}
