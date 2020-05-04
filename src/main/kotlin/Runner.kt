
fun main(){

    val meeting = Meeting("The Gathering of Dark Power", Location("Lair of the empty darkness"))


    println("Created Meeting: $meeting with name ${meeting.meetingName} and  at ${meeting.location}")

    val name = Name("The void")

    val participant = Participant(name, "thevoid@meeting.com")

    meeting.addParticipant(participant)



    val review = PersonalReview("Review the effort", Participant(Name("The life"), "thelife@meeting.com"), listOf(), Location("The dungeon of despair"))
    println("Created PersonalReview: $review with name ${review.meetingName} and  at ${review.location}")

    review.closeReview()
}