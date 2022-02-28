package dev.matyaqubov.pnotes

import android.app.Application
import dev.matyaqubov.pnotes.manager.PrefManager
import dev.matyaqubov.pnotes.model.Note

class MyApplication : Application() {
    companion object {
        val TAG = MyApplication::class.java.simpleName
        var instance: MyApplication? = null
        var notes=ArrayList<Note>()
        internal var prefManager: PrefManager? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        prefManager = PrefManager(this)
        notes.addAll(prefManager!!.getData())
    }
}