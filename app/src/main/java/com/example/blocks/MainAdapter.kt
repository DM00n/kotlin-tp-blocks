package com.example.blocks

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    val items: ArrayList<Squares> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.square_item, null))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

}
class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private val square: TextView = itemView.findViewById(R.id.square)

    fun bind(item: Squares, position: Int){
        val color: Int = if (position % 2 == 0) {
            Color.RED
        } else {
            Color.BLUE
        }

        square.text = position.toString()
        square.setBackgroundColor(color)
        square.width = item.side
        square.height = item.side
    }

}