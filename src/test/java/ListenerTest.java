import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ListenerTest {

    @Test
    public void someTest() {
        WebDriverManager.chromedriver().setup();
        EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MarkBeforeClickListener());
        driver.manage().window().maximize();

        driver.get("https://otus.ru/");
        driver.findElement(By.className("header3__nav-item-arrow-title")).click();
        driver.quit();
    }
}
