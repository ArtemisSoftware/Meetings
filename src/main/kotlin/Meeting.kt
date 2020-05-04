
class Meeting {

    internal val logger = Logger()

    fun addParticipant(name : String){

        if(verifyParticipant(name) == true) {
            println("Added: $name")
        }
    }


    private fun verifyParticipant(name : String) : Boolean {
        println("Try to verify")
        return true
    }


}