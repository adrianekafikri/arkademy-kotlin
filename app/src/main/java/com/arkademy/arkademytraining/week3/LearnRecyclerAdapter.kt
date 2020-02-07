package com.arkademy.arkademytraining.week3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arkademy.arkademytraining.R

/**
 * Created by adrianfikri on 2020-02-06.
 */
class LearnRecyclerAdapter : RecyclerView.Adapter<LearnRecyclerAdapter.AnimalViewHolder>() {

    val list = listOf("Rabbit", "Cat", "Deer", "Dog", "Sheep", "Fish", "Horse", "Butterfly",
        "Chicken", "Tiger", "Lion", "Giraffe", "Tomcat", "Fly", "Mosquito", "Camel", "Whale",
        "Dolphin", "Shark", "Gorilla", "Monkey", "Python", "Cobra")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.tvName.text = list[position]
        holder.tvPosition.text = (position + 1).toString()
    }

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvName = itemView.findViewById<TextView>(R.id.tv_name)
        var tvPosition = itemView.findViewById<TextView>(R.id.tv_position)
    }
}