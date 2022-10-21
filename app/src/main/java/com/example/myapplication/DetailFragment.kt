package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var listFragment: MutableList<Fragment> = mutableListOf()
    private var listText: MutableList<String> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val someInt = requireArguments().getInt("some_int")
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager)
        listFragment.add(FragmentMenu())
        listFragment.add(FragmentOrder())
        listText.add("Danh sách Menu")
        listText.add("Danh sách món ăn")

        val pagerAdapter = M00ViewPagerAdapter(
            listFragment,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        viewpager.adapter = pagerAdapter
        TabLayoutMediator(tabLayout,viewpager) { tab, position ->
            tab.customView = getCustomViewTab(
                (listText[position]),
            )
        }.attach()
        viewpager.offscreenPageLimit = listFragment.size

    }

    private fun getCustomViewTab(text: String): CustomTabVideo {
        val tab = CustomTabVideo(requireContext())
        tab.text.text = text
        return tab
    }

}