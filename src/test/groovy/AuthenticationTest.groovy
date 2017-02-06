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
//        open("http://test.shopdt.ru/terminal_mode/off")
        $(By.linkText("Да, продолжаем!")).click()
        Auth.authUser(user.login, user.pass)
//           $("#fid") - обращение по id
    }
}
