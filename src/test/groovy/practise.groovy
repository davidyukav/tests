
/*def amPM = Calendar.getInstance().get(Calendar.AM_PM)
if (amPM == Calendar.AM){
    println("Good morning ${amPM}")
} else {
    println("Good evening ${amPM}")
}*/
/*def addr = "http://twitter.com/statuses/friends_timeline.atom"
def authString = "username:password".getBytes().encodeBase64().toString()
def conn = addr.toURL().openConnection()
conn.setRequestProperty("Authorization", "Basic ${authString}")
if(conn.responseCode == 200){
    def feed = new XmlSlurper().parseText(conn.content.text)
    feed.entry.each{entry->
        println entry.author.name
        println entry.title
        println "-"*20
    }
}else{
    println "Something bad happened."
    println "${conn.responseCode}: ${conn.responseMessage}"
    }*/
import org.openqa.selenium.By
import org.testng.annotations.Test

import static com.codeborne.selenide.Condition.*
import static com.codeborne.selenide.Selenide.*

@Test()
void testAuth() {
    Map user = [
            login : '+79000000000',
            pass : '123456',
    ]
    open("http://test.shopdt.ru/")
    //   $(By.linkText("Да, продолжаем!")).click()
    $(".js-user-button").click()
    $(By.name("phone_email")).setValue(user.login)
    $(By.name("password")).setValue(user.pass)
    $(".js-tm-auth_btn").click()
    $(".b-little-message__text").waitUntil(hasText('Успешная авторизация.'), 10000)
}
