package dev.matyaqubov.pnotes.manager

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.matyaqubov.pnotes.activity.MainActivity
import dev.matyaqubov.pnotes.model.Note
import java.lang.reflect.Type
import java.security.Key

class PrefManager(context: Context) {
    internal val sharedPreferences: SharedPreferences?

    companion object {
        const val KEY = "notes"
        private var prefManager: PrefManager? = null
        fun getInstance(context: Context): PrefManager? {
            if (prefManager == null) {
                prefManager = PrefManager(context)
            }
            return prefManager
        }
    }

    init {
        sharedPreferences = context.getSharedPreferences("PNotes", Context.MODE_PRIVATE)
    }

    @SuppressLint("CommitPrefEdits")
    fun saveData(note: Note) {
        val prefsEditor = sharedPreferences!!.edit()
        val gson = Gson()
        val notes=getData()
        notes.add(note)
        prefsEditor.putString(KEY, gson.toJson(notes))
        prefsEditor.apply()
    }

    fun getData(): ArrayList<Note> {
        if (sharedPreferences!!.contains(KEY)) {
            val type: Type = object : TypeToken<ArrayList<Note>>() {}.type
            return Gson().fromJson(sharedPreferences.getString(KEY, ""), type)
        }
        return ArrayList()
    }
    fun updateNotes(){
        MainActivity.notes=getData()
    }
}