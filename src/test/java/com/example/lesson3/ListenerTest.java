package com.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListenerTest {

    //    @Test
//    public void someTest() {
//        WebDriverManager.chromedriver().setup();
//        EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver());
//        driver.register(new com.example.lesson3.MarkBeforeClickListener());
//        driver.manage().window().maximize();
//
//        driver.get("https://otus.ru/");
//        driver.findElement(By.className("header3__nav-item-arrow-title")).click();
//        driver.quit();
//    }
    private WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        iTestContext.setAttribute("driver", driver);
    }

    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void anotherTest() {
//        driver.get("https://otus.ru/");
//        driver.findElement(By.className("header3__nav-item-arrow-title2")).click();
//        driver.quit();

    }

    private WebElement waitAndRefresh(By locator) {
        return new WebDriverWait(driver, 6).until(new ExpectedCondition<WebElement>() {
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver webDriver) {
                try {
                    driver.findElement(locator);
                } catch (Exception e) {
                    driver.navigate().refresh();
                }
                return null;
            }
        });
    }
}
