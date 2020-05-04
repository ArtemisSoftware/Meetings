package com.artemisSoftware
import FileLogger
import Logger
import java.nio.file.Paths

fun main(){

    val postCode = UKPostCode("4dark")
    val looper: Logger = FileLogger(Paths.get("/some/file.log"))

    val meeting = Meeting("The Gathering of Dark Power",
                          UkAddress("The Lair", "Empty darkness", "The NoSpark", "Blight", postCode),
                          looper
    )


    println("Created Meeting: $meeting with name ${meeting.meetingName} and  at ${meeting.locationName}")

    val name = Name("The void")
    val participant = Participant(name, "thevoid@meeting.com")
    meeting.addParticipant(participant)


    println("")
    val review = PersonalReview("Review the effort", Participant(Name("The life"), "thelife@meeting.com"), listOf(), Room("The dungeon of despair"), looper)
    println("Created PersonalReview: $review with name ${review.meetingName} and  at ${review.locationName}")

    review.closeReview()
}