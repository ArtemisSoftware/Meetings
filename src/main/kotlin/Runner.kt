
fun main(){

    val meeting = Meeting("The Gathering of Dark Power", Location("Lair of the empty darkness"))


    println("Created: $meeting with name ${meeting.meetingName} and  at ${meeting.location}")

    val name = Name()
    name.name = "The void"

    val participant = Participant(name, "thevoid@meeting.com")



    meeting.addParticipant(participant)


   // meeting.
}