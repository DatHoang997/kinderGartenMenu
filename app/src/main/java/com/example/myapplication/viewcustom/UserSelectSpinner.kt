package com.example.myapplication.viewcustom

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner


@SuppressLint("AppCompatCustomView")
class UserSelectSpinner @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : Spinner(context, attrs) {

    private var isUserOpen = false

    private var onSelectSpinnerListener: OnSelectSpinnerListener? = null

    fun getOnSelectSpinnerListener(): OnSelectSpinnerListener? {
        return onSelectSpinnerListener
    }

    fun setOnSelectSpinnerListener(onSelectSpinnerListener: OnSelectSpinnerListener?) {
        this.onSelectSpinnerListener = onSelectSpinnerListener
    }

    init {
        registerEvenListenUserChoose()
    }

    private fun registerEvenListenUserChoose(){
        super.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (isUserOpen){
                    onSelectSpinnerListener?.onItemSelectByUser(position)
                    isUserOpen = false
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                isUserOpen = false
            }

        })
    }

    override fun performClick(): Boolean {
        isUserOpen = true
        if (onSelectSpinnerListener != null) {
            onSelectSpinnerListener!!.onOpenSelectMenu()
        }
        return super.performClick()
    }

    interface OnSelectSpinnerListener {
        fun onOpenSelectMenu()
        fun onItemSelectByUser(pos: Int)
    }

}