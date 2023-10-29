package com.example.blocks

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var count: Int = 0
    private lateinit var fab: FloatingActionButton
    //private lateinit var gridLayout: GridLayout
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab = findViewById(R.id.fab)
        recyclerView = findViewById(R.id.recycleView)

        val gridLayoutManager =  GridLayoutManager(this, if (this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 3)
        recyclerView.layoutManager = gridLayoutManager
        //gridLayout = findViewById(R.id.gridLayout)

        savedInstanceState?.let {

            //gridLayout.columnCount = if (this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 3
            for (i in 0 until it.getInt("count")){
                val tv = TextView(this)
                tv.layoutParams = RecyclerView.LayoutParams(TypedValue.COMPLEX_UNIT_DIP * 300, TypedValue.COMPLEX_UNIT_DIP * 300)
                tv.setPadding(10)
                tv.textAlignment=View.TEXT_ALIGNMENT_CENTER
                tv.textSize=TypedValue.COMPLEX_UNIT_SP.toFloat() * 30
                tv.setBackgroundColor(if (i % 2 ==0 ) {Color.RED} else {Color.BLUE})
                tv.text=i.toString()
                recyclerView.addView(tv)
                gridLayoutManager.addView(tv)
                //gridLayout.addView(tv)
            }
            count=it.getInt("count")
        }

        fab.setOnClickListener{
            val tv = TextView(this)
            tv.layoutParams = RecyclerView.LayoutParams(TypedValue.COMPLEX_UNIT_DIP * 300, TypedValue.COMPLEX_UNIT_DIP * 300)

            tv.setPadding(10)
            tv.textAlignment=View.TEXT_ALIGNMENT_CENTER
            tv.textSize=TypedValue.COMPLEX_UNIT_SP.toFloat() * 30
            tv.setBackgroundColor(if (count % 2 ==0 ) {Color.RED} else {Color.BLUE})
            tv.text=count.toString()
            //gridLayout.addView(tv)
            recyclerView.addView(tv)
            gridLayoutManager.addView(tv)
            count++
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }
}