package com.pm.requestdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class CustomAdapter (private val items: List<Employee>)
    : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val rootView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(rootView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = items[position]
        holder.apply {
            nameTextView.text = item.name
            ageTextView.text = item.age.toString()
        }
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView = view.employeename
        val ageTextView = view.employeeage
    }

}