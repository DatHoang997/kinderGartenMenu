package com.example.myapplication

import ItemsViewModel
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.AdapterList

class FragmentOrder : Fragment(R.layout.fragment_order) {
    val data = ArrayList<ItemsViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val someInt = requireArguments().getInt("some_int")
        val recyclerview = view.findViewById<RecyclerView>(R.id.rcv_list)
        val txt_add_food = view.findViewById<AppCompatTextView>(R.id.txt_add_food)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        data.add(ItemsViewModel(false, "Title"))
        data.add(ItemsViewModel(false, "Thịt kho"))
        data.add(ItemsViewModel(false, "Cá rán"))
        data.add(ItemsViewModel(false, "Trứng luộc"))
        data.add(ItemsViewModel(false, "Bánh mỳ"))

        val adapter = AdapterList(data)
        recyclerview.adapter = adapter
        txt_add_food.setOnClickListener {
            showDialog()
        }
    }


    private fun showDialog() {
        val dialog = activity?.let { Dialog(it) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(true)
        dialog?.setContentView(R.layout.dialog_add_food)
        val btnDel = dialog?.findViewById(R.id.btn_del) as AppCompatButton
        btnDel.setOnClickListener { dialog.dismiss() }
        dialog?.show()

    }
}