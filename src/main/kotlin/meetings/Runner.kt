package com.artemisSoftware.meetings
import com.artemisSoftware.UkAddress
import java.nio.file.Paths

fun main(){

    val postCode = UKPostCode("4dark")
    val looper: Logger = FileLogger(Paths.get("/some/file.log"))

    val meeting = Meeting(
        "The Gathering of Dark Power",
        UkAddress(
            "The Lair",
            "Empty darkness",
            "The NoSpark",
            "Blight",
            postCode
        ),
        looper
    )


    println("Created Meeting: $meeting with name ${meeting.meetingName} and  at ${meeting.locationName}")

    var name = Name("The void")
    var participant = Participant(name, "thevoid@meeting.com")
    meeting.addParticipant(participant)

    name = Name("The darkness")
    participant = Participant(name, "thedarkness@meeting.com")
    meeting.addParticipant(participant)


    println("------Participants-------")
    meeting.participants.forEach{
        println(it.name)
    }
    println("-------------------------")

    println("")
    val review = PersonalReview(
        "Review the effort",
        Participant(Name("The life"), "thelife@meeting.com"),
        listOf(),
        Room("The dungeon of despair"),
        looper
    )
    println("Created PersonalReview: $review with name ${review.meetingName} and  at ${review.locationName}")

    review.closeReview()
}