package com.arkademy.arkademytraining.week4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arkademy.arkademytraining.R
import com.arkademy.arkademytraining.databinding.ItemEmployeeBinding

/**
 * Created by adrianfikri on 2020-02-13.
 */
class EmployeeAdapter : RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder>() {

    private val items = mutableListOf<EmployeeModel>()

    fun addList(list: List<EmployeeModel>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {
        return EmployeeHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_employee, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
        val item = items[position]
        holder.binding.tvAge.text = item.age
        holder.binding.tvName.text = item.name
        holder.binding.tvSalary.text = item.salary
    }

    class EmployeeHolder(val binding: ItemEmployeeBinding) : RecyclerView.ViewHolder(binding.root)
}