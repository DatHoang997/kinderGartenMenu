package com.example.myapplication.adapter

import ItemsViewModel
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class AdapterList(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<AdapterList.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]

        if(position == 0){
            holder.txt_stt.setBackgroundResource(R.color.bg_item)
            holder.txt_name.setBackgroundResource(R.color.bg_item)
            holder.txt_status.setBackgroundResource(R.color.bg_item)
        }else{
            holder.txt_stt.text = position.plus(1).toString()
            holder.txt_name.text = itemsViewModel.name
        }

    }


    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val txt_stt: AppCompatTextView = itemView.findViewById(R.id.txt_stt)
        val txt_name: AppCompatTextView = itemView.findViewById(R.id.txt_name)
        val txt_status: AppCompatTextView = itemView.findViewById(R.id.txt_status)
    }
}