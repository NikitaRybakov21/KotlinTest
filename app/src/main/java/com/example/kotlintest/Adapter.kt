package com.example.kotlintest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class Adapter(var list : ArrayList<Card>, var fragmentKotlin : FragmentKotlin) : RecyclerView.Adapter<Adapter.NewViewHolder>() {

}