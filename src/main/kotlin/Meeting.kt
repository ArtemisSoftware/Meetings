package com.artemisSoftware
import Logger
import java.nio.file.Path
import java.nio.file.Paths

open class Meeting (val meetingName: String, open val location: Location, val logger : Logger){


    open val locationName = ""


    fun addParticipant(participant : Participant){

        //logger.debug("Participant added")

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

class PersonalReview(meetingName: String, val employee: Participant, reviewers: List<Participant>, override val location : Room, logger : Logger)
    : Meeting(meetingName, location, logger){


    override val locationName: String
        get() = location.roomName


    fun closeReview(){
        println("Review ended")
        verifyMeeting()
    }

    override fun verifyMeeting() {
        println("PersonalReview: verify meeting")
        super.verifyMeeting()
    }
}