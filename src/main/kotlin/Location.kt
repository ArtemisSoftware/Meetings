open class Location

class Room(roomName : String) : Location()

class TheGateringAddress(val firstLine: String,
                val secondLine: String,
                val city: String,
                val county: String,
                val postCode: String) : Location()