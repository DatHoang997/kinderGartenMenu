package com.example.myapplication

import ItemsViewModel
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.AdapterList

class FragmentOrder : Fragment(R.layout.fragment_order) {
    val data = ArrayList<ItemsViewModel>()
    var adapter :AdapterList?= null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val someInt = requireArguments().getInt("some_int")
        val recyclerview = view.findViewById<RecyclerView>(R.id.rcv_list)
        val txt_add_food = view.findViewById<AppCompatTextView>(R.id.txt_add_food)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        data.add(ItemsViewModel(false, "Title"))
        data.add(ItemsViewModel(true, "Thịt kho"))
        data.add(ItemsViewModel(false, "Cá rán"))
        data.add(ItemsViewModel(true, "Trứng luộc"))
        data.add(ItemsViewModel(false, "Bánh mỳ"))

        adapter = AdapterList(data)
        recyclerview.adapter = adapter
        txt_add_food.setOnClickListener {
            showDialog()
        }
    }


    private fun showDialog() {

        val view = LayoutInflater.from(requireActivity()).inflate(R.layout.dialog_add_food, null)
        val dialogBuilder = AlertDialog.Builder(requireActivity(), R.style.StyleDialogUpdateVersion)
        dialogBuilder.setCancelable(true)
        val dialog = dialogBuilder.create()
         var  btn_del = view.findViewById<AppCompatButton>(R.id.btn_del_dialog)
         var  btn_save_dialog = view.findViewById<AppCompatButton>(R.id.btn_save_dialog)
         var  edt_name_add = view.findViewById<AppCompatEditText>(R.id.edt_name_add)
         var  edt_name_des = view.findViewById<AppCompatEditText>(R.id.edt_name_des)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setView(view)
        dialog.setCancelable(true)
        dialog.show()
        btn_del?.setOnClickListener {
            dialog.dismiss()
        }

        btn_save_dialog?.setOnClickListener {
            if(edt_name_add?.text.toString().isNullOrBlank()){
                Toast.makeText(requireActivity(), "Vui lòng nhập tên món ăn", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(edt_name_des?.text.toString().isNullOrBlank()){
                Toast.makeText(requireActivity(), "Vui lòng nhập mô tả", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            data.add(ItemsViewModel(true, edt_name_add.text.toString()))
            adapter?.notifyDataSetChanged()
            dialog.dismiss()

        }


    }
}