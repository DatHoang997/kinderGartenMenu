package com.example.myapplication.viewcustom

import android.annotation.SuppressLint
import java.util.*

@SuppressLint("SimpleDateFormat")
object TimeUtils {

    fun getTimeStamp(day: Int = 0, month: Int = 0, year: Int = 0): Long {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, day)
        calendar.add(Calendar.MONTH, month)
        calendar.add(Calendar.YEAR, year)
        return calendar.time.time
    }
}