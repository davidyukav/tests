import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.assertTrue;
//поиск в браузере хром и переход на страницу хабра + закрытие браузера
public class example {
    public WebDriver driver;

    @Before
    public void setUp() {
    System.setProperty("webdriver.chrome.driver", "/home/user/IdeaProjects/tests/utils/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void search_selenide_in_google() {
        driver.get("http://google.com/");
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        List<WebElement> urls= driver.findElements(By.tagName("h3"));
        for (WebElement url : urls) {
            if (url.getAttribute("textContent").contains("Хаб")) {
                driver.navigate().to(
                        url.findElement(By.tagName("a")).getAttribute("href"));
                break;
            }
        }
        String getUrlOpenPage = (String) ((JavascriptExecutor) driver)
                .executeScript("return window.document.location.toString();");
        assertTrue(getUrlOpenPage.contains("habrahabr.ru"));
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

