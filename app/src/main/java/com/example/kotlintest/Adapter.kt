package com.example.kotlintest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class Adapter(var list : ArrayList<Card>, var fragmentKotlin : FragmentKotlin) : RecyclerView.Adapter<Adapter.NewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
       return NewViewHolder(layoutInflater)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        fragmentKotlin.registerForContextMenu(holder.cardView)
        val card = list[position]

        holder.cardView.setOnLongClickListener {
            holder.cardView.showContextMenu()
            fragmentKotlin.remove(card)
            true
        }

        val string = list[position].text +  list[position].pos
        holder.textView.text = string
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView : TextView = itemView.findViewById(R.id.cardText)
        var cardView : CardView = itemView.findViewById(R.id.card)
    }
}