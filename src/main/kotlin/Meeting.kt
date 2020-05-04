
open class Meeting (val meetingName: String, val location: Location = Location("")){

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

class PersonalReview(meetingName: String, val employee: Participant, reviewers: List<Participant>, location : Location = Location("The darklight room"))
    : Meeting(meetingName, location)