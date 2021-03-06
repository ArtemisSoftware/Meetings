package com.artemisSoftware.meetings

class Name(val name : String) {

    init {

        if(name.isNullOrBlank()) throw  IllegalArgumentException()

    }

    override fun toString(): String {
        return name
    }

}