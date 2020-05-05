package com.artemisSoftware.meetings

import kotlinx.serialization.Serializable

interface Entity {

    val id: Int

}

@Serializable
class MeetingEntity(override val id: Int, val meetingName: String, val location: LocationEntity, val participants: List<ParticipantEntity>) : Entity  {
    override fun toString(): String {
        return "MeetingEntity(id=$id, meetingName=$meetingName, location=${location.toString()}, participants=${participants.toString()}"
    }
}

@Serializable
class ParticipantEntity(val name: String) {
    override fun toString(): String {
        return "ParticipantEntity(name=$name)"
    }
}

@Serializable
class LocationEntity(val roomName: String) {
    override fun toString(): String {
        return "LocationEntity(roomName=$roomName)"
    }
}