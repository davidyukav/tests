import org.jsoup.Jsoup
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

/**
 * Created by user on 30.01.17.
 */
class NumberOfItemsOnPage {
    @DataProvider(name = "ListUrls")
    Object[][] getListUrl(){
        [
                [
                        'http://vladivostok.domotekhnika.ru/televizory-i-videotekhnika/televizory/?inStock=1&sort%5Bby%5D=date&sort%5Border%5D=asc'
                ],
                [
                        'http://vladivostok.domotekhnika.ru/televizory-i-videotekhnika/televizory/'
                ],
                [
                        'http://vladivostok.domotekhnika.ru/brand/acer/'
                ],
        ]
    }

    @Test(dataProvider = "ListUrls")
    void testCheckProductsCount(url) {
        def result = Jsoup.connect(url).timeout(0).get().body()
        assert result.select('.i-catalog-plate').size().toInteger() == 24
    }}
