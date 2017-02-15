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

    static void registerUser(String fio, String phone, String pass, String email) {
        $(".js-user-button").click()
        $(By.linkText("Регистрация")).click()
        $(By.name("fio")).setValue(fio)
        $(By.name("phone")).setValue(phone)
        $(By.cssSelector(".js-auth__register-form .b-form__text.i-show-pass")).setValue(pass)
        $(By.name("email")).setValue(email)
        $(By.name("terms")).parent().click()
        $(".js-tm-registration_btn").click()

    }
}