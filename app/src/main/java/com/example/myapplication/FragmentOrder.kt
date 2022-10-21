package com.example.myapplication

import DataDetail
import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.AdapterList

class FragmentOrder : Fragment(R.layout.fragment_order),OnClickItem {
    val data  : MutableList<DataDetail> = mutableListOf()
    var adapter :AdapterList?= null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerview = view.findViewById<RecyclerView>(R.id.rcv_list)
        val txt_add_food = view.findViewById<AppCompatTextView>(R.id.txt_add_food)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        data.add(DataDetail(false, "Title",""))
        data.add(DataDetail(true, "Thịt kho","Ngon"))
        data.add(DataDetail(false, "Cá rán","Ngon"))
        data.add(DataDetail(true, "Trứng luộc","Ngon"))
        data.add(DataDetail(false, "Bánh mỳ","Ngon"))

        adapter = AdapterList(data,this)
        recyclerview.adapter = adapter
        txt_add_food.setOnClickListener {
            showDialog(1,0)
        }
    }


    @SuppressLint("MissingInflatedId")
    private fun showDialog(typeDialog: Int,position: Int, item: DataDetail?=null) {

        val view = LayoutInflater.from(requireActivity()).inflate(R.layout.dialog_add_food, null)
        val dialogBuilder = AlertDialog.Builder(requireActivity(), R.style.StyleDialogUpdateVersion)
        dialogBuilder.setCancelable(true)
        val dialog = dialogBuilder.create()
         var  btn_del = view.findViewById<AppCompatButton>(R.id.btn_del_dialog)
         var  btn_save_dialog = view.findViewById<AppCompatButton>(R.id.btn_save_dialog)
         var  edt_name_add = view.findViewById<AppCompatEditText>(R.id.edt_name_add)
         var  edt_name_des = view.findViewById<AppCompatEditText>(R.id.edt_name_des)
         var  cb_status = view.findViewById<CheckBox>(R.id.cb_status)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setView(view)
        dialog.setCancelable(true)
        dialog.show()
        btn_del?.setOnClickListener {
            data.removeAt(position)
            adapter?.notifyDataSetChanged()
            dialog.dismiss()
        }

        when (typeDialog) {
            1 -> {
                btn_del.hide()
            }
            2 -> {
                cb_status.isChecked= item?.status == true
                edt_name_add.setText(item?.name, TextView.BufferType.EDITABLE)
                edt_name_des.setText(item?.des, TextView.BufferType.EDITABLE)

            }
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
            if(typeDialog==1){
                data.add(DataDetail(cb_status.isChecked, edt_name_add.text.toString(),edt_name_des.text.toString()))
            }else{
                data.set(position,DataDetail(cb_status.isChecked, edt_name_add.text.toString(),edt_name_des.text.toString()))
            }

            adapter?.notifyDataSetChanged()
            dialog.dismiss()
        }
    }

    override fun clickItem(item: DataDetail, position: Int) {
        showDialog(2,position,item)
    }
}