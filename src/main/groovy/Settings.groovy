import org.testng.annotations.BeforeTest

class Settings {
    public static Boolean isDev
    public static String domen
    public static String browser

    static String setBrowser() {
        browser = "chrome"
        browser
    }

    static void getBrowser() {
        browser = setBrowser()
        if (browser == "chrome") {
            startChrome()
        }
    }

    static void startChrome() {
        System.setProperty("webdriver.chrome.driver", "\\tests\\chromedriver.exe")
        System.setProperty("selenide.browser", "Chrome")
    }

    static Boolean setServer() {
        isDev = true
        isDev
    }

    static String getDomen() {
        setServer()
        if (isDev) {
            domen = "http://dev:dtdev@test.shopdt.ru/"
        } else {
            domen = "http://domotekhnika.ru"
        }
        domen
    }

    @BeforeTest()
    void setSettings() {
        getBrowser()
        getDomen()
    }
}
