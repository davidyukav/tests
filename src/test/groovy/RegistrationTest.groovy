import org.testng.annotations.Test
import static com.codeborne.selenide.Selenide.open

class RegistrationTest extends Settings {
    @Test()
    void testReg(){
    Map user = [
            fio : 'Иванов Иван Иванович',
            phone : '+79999999999',
            pass : '654321',
            email : 'email@email.email'
    ]
        open(domen)
        Auth.registerUser(user)

    }

}
