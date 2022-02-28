package dev.matyaqubov.pnotes.model

import java.io.Serializable

data class Note(
    val date:String,
    val text:String,
) :Serializable