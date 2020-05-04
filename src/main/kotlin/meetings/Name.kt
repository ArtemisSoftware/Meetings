package com.artemisSoftware.meetings

class Name(val name : String) {

    init {

        if(name.isNullOrBlank()) throw  IllegalArgumentException()

    }


}