package dev.matyaqubov.pnotes.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dev.matyaqubov.pnotes.MyApplication
import dev.matyaqubov.pnotes.R
import dev.matyaqubov.pnotes.adapter.NoteAdapter
import dev.matyaqubov.pnotes.helper.AddDialog
import dev.matyaqubov.pnotes.manager.PrefManager
import dev.matyaqubov.pnotes.model.Note

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var context: Context

    companion object{
        var notes=MyApplication.notes
        var adapter=NoteAdapter(notes)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context=this
        initViews()
    }

    private fun initViews() {
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=GridLayoutManager(this,1)
        recyclerView.adapter=adapter
        val add=findViewById<FloatingActionButton>(R.id.b_add_note)
        add.setOnClickListener {
            val dialog=AddDialog(this)
            dialog.show()
        }
    }

}