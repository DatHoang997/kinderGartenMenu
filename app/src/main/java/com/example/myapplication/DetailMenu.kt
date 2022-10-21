package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.myapplication.viewcustom.UserSelectSpinner

class DetailMenu : Fragment(R.layout.fragment_detail_menu) {
    var spinner :UserSelectSpinner? =null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val someInt = requireArguments().getInt("some_int")

        val adapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.state_date,
            R.layout.item_default_show_tone
        )
        adapter.setDropDownViewResource(R.layout.item_choose_tone)
        spinner = view.findViewById(R.id.spinner)
        spinner?.adapter = adapter
    }

}