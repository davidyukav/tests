
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

