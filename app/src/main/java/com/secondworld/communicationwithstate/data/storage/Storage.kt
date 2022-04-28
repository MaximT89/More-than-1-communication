package com.secondworld.communicationwithstate.data.storage

import javax.inject.Inject

interface Storage {

    fun name() : String

    class Base @Inject constructor() : Storage{
        override fun name() = listOf(
            "Max",
            "Tony",
            "Ann",
            "Sara",
            "Ann",
            "Peter",
            "Cory",
            "Mike",
            "Dan",
            "Nikita",
            "Akbar",
            "Sonia",
            "Gloria",
            "John"
        ).random()
    }
}