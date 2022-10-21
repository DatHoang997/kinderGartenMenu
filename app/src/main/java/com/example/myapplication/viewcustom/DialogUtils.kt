package com.example.myapplication.viewcustom

import android.content.Context

object DialogUtils {
    fun showDialogDatePicker(
        context: Context,
        initTime: Long?,
        onDoneListener: (timeSelected: Long?) -> Unit
    ) {
//        DatePickerDialogFragment.getInstance(context, initTime, onDoneListener).show()
    }

}