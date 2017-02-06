import org.openqa.selenium.By

import static com.codeborne.selenide.Selenide.$


class Registration {

static void RegistrationUser(String fio, String phone, String pass, String email) {
    $(".js-user-button").click()
    $(By.linkText("Регистрация")).click()
    $(By.name("fio")).setValue(fio)
    $(By.name("phone")).setValue(phone)
    $(By.name("password")).setValue(pass)
    $(By.name("email")).setValue(email)
    $(By.name("terms")).setSelected(true)
    $(".js-tm-registration_btn").click()

}

}
