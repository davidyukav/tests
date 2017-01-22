import org.jsoup.Jsoup
import org.testng.annotations.Test

class TestTest {

    @Test()
    void BlablaTest() {
        def result = Jsoup.connect("http://www.domotekhnika.ru  ")
        println result.class
        println result
    }

}
