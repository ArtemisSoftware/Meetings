
fun main(){

    val meeting = Meeting()


    println("Created: $meeting")

    val participant = Participant()

    val name = Name()
    name.name = "The void"
    name.name = ""

    participant.name = name
    participant.email ="thevoid@meeting.com"

    meeting.addParticipant(participant)


   // meeting.
}