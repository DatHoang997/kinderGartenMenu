package com.example.myapplication

import DataDetail
import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.os.bundleOf
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.AdapterList
import com.example.myapplication.adapter.AdapterMenu
import com.example.myapplication.viewcustom.UserSelectSpinner

class FragmentMenu : Fragment(R.layout.fragment_order),OnClickItem {
    val data  : MutableList<DataDetail> = mutableListOf()
    var adapter2 : AdapterMenu?= null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerview = view.findViewById<RecyclerView>(R.id.rcv_list)
        val txt_add_food = view.findViewById<AppCompatTextView>(R.id.txt_add_food)
        txt_add_food.text =" Thêm Menu"

        recyclerview.layoutManager = LinearLayoutManager(activity)
        data.add(DataDetail(false, "Title",""))
        data.add(DataDetail(true, "Sáng","Ngon","01/09/2022"))
        data.add(DataDetail(false, "Trưa","Ngon","01/09/2022"))
        data.add(DataDetail(true, "Chiều","Ngon","01/09/2022"))


        adapter2 = AdapterMenu(data,this)
        recyclerview.adapter = adapter2
        txt_add_food.setOnClickListener {
            showDialog(1,0)
        }
    }




    @SuppressLint("MissingInflatedId")
    private fun showDialog(typeDialog: Int,position: Int, item: DataDetail?=null) {

        val view = LayoutInflater.from(requireActivity()).inflate(R.layout.fragment_detail_menu, null)
        val dialogBuilder = AlertDialog.Builder(requireActivity(), R.style.StyleDialogUpdateVersion)
        dialogBuilder.setCancelable(true)
        val dialog = dialogBuilder.create()
          var spinner = view.findViewById<UserSelectSpinner>(R.id.spinner)
        var  btn_del = view.findViewById<AppCompatButton>(R.id.btn_del_dialog_menu)
        var  btn_save_dialog = view.findViewById<AppCompatButton>(R.id.btn_save_dialog_menu)
        var  edt_name_ad1 = view.findViewById<AppCompatEditText>(R.id.edt_name_add_1)
        var  cb_menu = view.findViewById<CheckBox>(R.id.cb_menu_add)
        var  txt_name_date_value = view.findViewById<AppCompatTextView>(R.id.txt_name_date_value)
        val adapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.state_date,
            R.layout.item_default_show_tone
        )
        adapter.setDropDownViewResource(R.layout.item_choose_tone)
        spinner = view.findViewById(R.id.spinner)
        spinner?.adapter = adapter
        var position = 0
        spinner.setOnSelectSpinnerListener(object :
            UserSelectSpinner.OnSelectSpinnerListener {

            override fun onOpenSelectMenu() {}

            override fun onItemSelectByUser(pos: Int) {
                position = pos
            }
        })

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setView(view)
        dialog.setCancelable(true)
        dialog.show()
        when (typeDialog) {
            1 -> {
                btn_del.hide()
            }
            2 -> {

            }
        }
         btn_save_dialog.setOnClickListener {

             if(edt_name_ad1?.text.toString().isNullOrBlank()){
                 Toast.makeText(requireActivity(), "Vui lòng nhập ít nhất 1 món ăn", Toast.LENGTH_LONG).show()
                 return@setOnClickListener
             }
             var buoi = ""
             when (position) {
                 0 -> {
                     buoi = " Buổi sáng"
                 }
                 1 -> {
                     buoi = " Buổi trưa"
                 }
                 2 -> {
                     buoi = " Buổi chiều"
                 }
             }
             data.add(DataDetail(cb_menu.isChecked,buoi,""
                 ,txt_name_date_value.text.toString()))
             adapter2?.notifyDataSetChanged()
             dialog.dismiss()
         }

    }

    override fun clickItem(item: DataDetail, position: Int) {

    }
}