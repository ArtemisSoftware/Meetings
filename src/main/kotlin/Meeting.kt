
class Meeting {

    private val logger = Logger()

    val meetingName: String = ""

    fun addParticipant(participant : Participant){

        if(verifyParticipant(participant) == true) {
            println("Added: ${participant.participantName}")
        }
    }


    private fun verifyParticipant(participant : Participant) : Boolean {
        println("Try to verify")
        return true
    }


}

class Participant{

    var name : Name = Name()
    var email = ""

    val participantName
        get() = name.name

    val canonicalEmail: String
        get() = email.toUpperCase()
}

class Name {

    var name : String = ""
        set(value : String){
            if(value.isNullOrBlank()) throw  IllegalArgumentException()
            field = value
        }
}