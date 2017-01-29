import com.codeborne.selenide.Condition
import org.openqa.selenium.By
import org.testng.annotations.Test

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.open

class AuthenticationTest extends Settings{
    @Test()
    void testAuth() {
        Map user = [
                login : '+79000000000',
                pass : '123456',
        ]

        open(domen)
        open("http://test.shopdt.ru/")
        $(By.linkText("Да, продолжаем!")).click()
        $(".js-user-button").click()
        $(By.name("phone_email")).setValue(user.login)
        $(By.name("password")).setValue(user.pass)
        $(".js-tm-auth_btn").click()
        $(".b-little-message__text").waitUntil(Condition.hasText('Успешная авторизация.'), 10000)
//           $("#fid") - обращение по id
    }
}
