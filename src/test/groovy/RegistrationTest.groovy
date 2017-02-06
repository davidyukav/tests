import org.testng.annotations.Test

class RegistrationTest extends Settings {
    @Test()
    void testReg(){
    Map user = [
            fio : 'Иванов Иван Иванович',
            phone : '+79999999999',
            pass : '654321',
            email : 'email@email.email'
    ]
    }

}
