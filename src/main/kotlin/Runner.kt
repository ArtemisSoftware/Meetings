
fun main(){

    val meeting = Meeting("The Gathering of Dark Power")


    println("Created: $meeting with name ${meeting.meetingName}")

    val name = Name()
    name.name = "The void"

    val participant = Participant(name, "thevoid@meeting.com")



    meeting.addParticipant(participant)


   // meeting.
}