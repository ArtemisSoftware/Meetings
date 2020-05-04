package com.artemisSoftware

import java.nio.file.Path

interface Message{
    fun info(){

    }
}


class FileLogger(val file: Path) : Logger, Message{

        override fun debug(msg: String) {
        }

        override fun warn(msg: String) {
        }

        override fun info(msg: String) {
            super<Message>.info()
            super<Logger>.info(msg)
        }
}

class ConsoleLogger(val file: Path) : Logger{

        override fun debug(msg: String) {
        }

        override fun warn(msg: String) {
        }


}