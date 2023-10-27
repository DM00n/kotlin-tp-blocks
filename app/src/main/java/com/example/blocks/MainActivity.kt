package com.example.blocks

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        val span: Int = if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {3} else {4}

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MainAdapter()
        recyclerView = findViewById(R.id.recycleView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, span)

        savedInstanceState?.let {
            for (i in 0 until it.getInt("size")){
                adapter.items.add(Squares("",0))
            }
        }

        fab = findViewById(R.id.button)

        fab.setOnClickListener{
            adapter.items.add(Squares("",0))
            adapter.notifyItemInserted(adapter.items.size - 1)
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("size", adapter.itemCount)
    }
}