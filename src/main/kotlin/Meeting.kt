
class Meeting {

    private val logger = Logger()

    val meetingName: String = ""

    fun addParticipant(participant : Participant){

        if(verifyParticipant(participant) == true) {
            println("Added: ${participant.name}")
        }
    }


    private fun verifyParticipant(participant : Participant) : Boolean {
        println("Try to verify")
        return true
    }


}

class Participant{

    var name = ""
    var email = ""

}