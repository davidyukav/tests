import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By
import org.testng.annotations.Test

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.open

class AuthenticationTest {
    @Test()
    void testAuth() {
        Map user = [
                login : '+79000000000',
                pass : '123456',
        ]

        System.setProperty("webdriver.chrome.driver", "D:\\tests\\chromedriver.exe")
        System.setProperty("selenide.browser", "Chrome")
        open("http://dev:dtdev@test.shopdt.ru/")
        open("http://test.shopdt.ru")
        $(By.linkText("Да, продолжаем!")).click()
        $(".js-user-button").click()
        $(By.name("phone_email")).setValue(user.login)
        $(By.name("password")).setValue(user.pass)
        $(".js-tm-auth_btn").click()
        $(".b-little-message__text").waitUntil(Condition.hasText('Успешная авторизация.'), 10000)
//           $("#fid") - обращение по id
    }
}
