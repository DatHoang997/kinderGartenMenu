package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentOrder : Fragment(R.layout.fragment_order) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val someInt = requireArguments().getInt("some_int")
    }
}