
fun main(){

    val meeting = Meeting()


    println("Created: $meeting")

    val participant = Participant()
    participant.name = "The void"
    participant.email ="thevoid@meeting.com"

    meeting.addParticipant(participant)


   // meeting.
}