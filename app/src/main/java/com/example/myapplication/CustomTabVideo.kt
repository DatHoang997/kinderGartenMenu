package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


class CustomTabVideo(context: Context, attributeSet: AttributeSet? = null) :
    LinearLayout(context, attributeSet) {

    var text: TextView


    init {
        inflate(getContext(), R.layout.custom_tab_video_viewpager, this)
        text = findViewById(R.id.tvIconTab)

    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)
        val color = if (selected) {
            R.color.black
        } else {
            R.color.gray_666
        }
        text.setTextColorEx(color)
    }
}