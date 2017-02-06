import org.jsoup.Jsoup
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.annotations.Test

class TestTest {

    @Test()
    void BlablaTest() {
        def result = Jsoup.connect("http://www.domotekhnika.ru")
        println result.class
        println result
        def browser = new FirefoxDriver()
        browser.get("http://www.domotekhnika.ru")
    browser.close()}

}
