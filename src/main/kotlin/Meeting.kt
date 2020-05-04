
open class Meeting (val meetingName: String, val location: Location = Location()){

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


    protected open fun verifyMeeting() {
        println("Meeting: verify meeting")
    }
}

class PersonalReview(meetingName: String, val employee: Participant, reviewers: List<Participant>, location : Location = Location())
    : Meeting(meetingName, location){

    fun closeReview(){
        println("Review ended")
        verifyMeeting()
    }

    override fun verifyMeeting() {
        println("PersonalReview: verify meeting")
        super.verifyMeeting()
    }
}