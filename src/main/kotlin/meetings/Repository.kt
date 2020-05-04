package com.artemisSoftware.meetings

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonDecodingException
import kotlinx.serialization.list
import java.io.File

//interface IMeetingRepository {
//    fun get() : List<Meeting>
//    fun get(id: Int) : Meeting
//    fun create(meeting: Meeting) : Meeting
//    fun update(meeting: Meeting): Boolean
//    fun delete(id: Int): Boolean
//}

interface IRepository<T> {
    fun get() : List<T>
    fun get(id: Int) : T
    fun create(meeting: T) : T
    fun update(meeting: T): Boolean
    fun delete(id: Int): Boolean
}

interface IMeetingRepository : IRepository<MeetingEntity>

abstract class FileSystemRepository<T>(val serializer: IJsonSerializer<T>, val filename: String = "database.json") : IRepository<T> {
    init {
        val file = File(filename)
        if(!file.isFile) file.createNewFile()
        println(file.absolutePath)
    }
}

class MeetingFileSystemRepository(serializer: IJsonSerializer<MeetingEntity>) : FileSystemRepository<MeetingEntity>(serializer), IMeetingRepository {
    private val json = Json(JsonConfiguration.Default)

    private fun meetings(): List<MeetingEntity> {

        // open file
        val data = File(filename).readText()
        // deserialize meetings

        return serializer.read(data)
    }


    override fun get(): List<MeetingEntity> {
        return meetings()
    }


    override fun get(id: Int): MeetingEntity {
        val meetings = meetings()
        return meetings.first { it.id == id }
    }

    override fun create(entity: MeetingEntity): MeetingEntity {
        val meetings = meetings()
        val mutableMeetings = meetings.toMutableList()
        val newEntity = MeetingEntity(id = meetings.size + 1, location = entity.location,meetingName = entity.meetingName, participants = entity.participants)
        mutableMeetings.add(newEntity)

        // serialize and save
        saveJsonMeetings(mutableMeetings)

        // add a new one
        return entity
    }

    private fun saveJsonMeetings(mutableMeetings: MutableList<MeetingEntity>) {
        val jsonData = serializer.write(mutableMeetings)

        File(filename).writeText(jsonData)
    }

    override fun update(entity: MeetingEntity): Boolean {
        val meetings = meetings()
        val filteredMeetings = meetings.filter { it.id != entity.id }.toMutableList()
        filteredMeetings.add(entity)

        saveJsonMeetings(filteredMeetings)

        return true
    }

    override fun delete(id: Int): Boolean {
        val meetings = meetings()
        val filteredMeetings = meetings.filter { it.id != id }.toMutableList()

        saveJsonMeetings(filteredMeetings)

        return true
    }

}























