package com.example.myapplication.adapter

import DataDetail
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.OnClickItem
import com.example.myapplication.R

class AdapterMenu(private val mList: List<DataDetail>, val onClickItem: OnClickItem)
    : RecyclerView.Adapter<AdapterMenu.ViewHolder>() {

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
            holder.txt_name.text= "Bữa ăn"
            holder.txt_status.text= "Ngày"
        }else{
            holder.txt_stt.text = position.toString()
            holder.txt_name.text = itemsViewModel.name
            holder.txt_status.text = itemsViewModel.date
            holder.root_parent.setOnClickListener {
                onClickItem.clickItem(itemsViewModel,position)
            }
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
        val root_parent: LinearLayoutCompat = itemView.findViewById(R.id.root_parent)

    }
}