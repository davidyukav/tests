import com.codeborne.selenide.Condition
import org.openqa.selenium.By
import org.testng.annotations.Test

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.open

class Auth {

    static void authUser(String login, String pass) {
        $(".js-user-button").click()
        $(By.name("phone_email")).setValue(login)
        $(By.name("password")).setValue(pass)
        $(".js-tm-auth_btn").click()
        $(".b-little-message__text").waitUntil(Condition.hasText('Успешная авторизация.'), 10000)
    }
}
