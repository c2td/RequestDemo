package com.pm.requestdemo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pm.requestdemo.data.Movie
import com.pm.requestdemo.R
import kotlinx.android.synthetic.main.list_item.view.*

class CustomAdapter (private val items: List<Movie>)
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
            titleTextView.text = item.title
            descriptionTextView.text = item.description
        }
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView = view.title
        val descriptionTextView = view.description
    }

}