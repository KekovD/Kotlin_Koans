fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
    val personalInfo = client?.personalInfo ?: return
    val email = personalInfo.email ?: return

    mailer.sendMessage(email, message ?: return);
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}
