package com.artemisSoftware.meetings

class Participant(val name: Name, val email: String) {


    val participantName
        get() = name.name

    val canonicalEmail: String
        get() = email.toUpperCase()
}