package com.slowhand.kt.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.slowhand.kt.R

class ListAdapter(
    private val context: Context,
    private val userList: List<String>
) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.row_list_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.apply {
            userName.text = userList[position]
        }
    }

    inner class ListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val userName = view.findViewById<TextView>(R.id.userName)
    }
}