package com.example.myapplication
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView

class MainFragment  : Fragment(R.layout.fragment_main){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val someInt = requireArguments().getInt("some_int")
        val btn_login = view.findViewById<AppCompatButton>(R.id.btn_login)
         btn_login.setOnClickListener {
             val bundle = bundleOf("some_int" to 0)
             requireActivity().supportFragmentManager.commit {
                 setReorderingAllowed(true)
                 add<FragmentOrder>(R.id.fragment_container_view, args = bundle)
             }
         }
    }
}