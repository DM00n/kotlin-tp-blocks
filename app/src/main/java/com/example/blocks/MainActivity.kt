package com.example.blocks

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: Button
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MainAdapter()
        recyclerView = findViewById(R.id.recycleView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(
            this,
            if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                3
            } else {
                4
            }
        )
        savedInstanceState?.let {
            for (i in 0 until it.getInt("count")) {
                adapter.items.add(i)
            }
        }
        fab = findViewById(R.id.fab)
        fab.setOnClickListener {
            adapter.items.add(adapter.items.size - 1)
            adapter.notifyItemInserted(adapter.items.size - 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", adapter.itemCount)
    }
}