
class Meeting (val meetingName: String, val location: Location = Location("")){

    private val logger = Logger()



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


class Location (val address : String){



}