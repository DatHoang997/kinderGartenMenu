package com.example.myapplication

import android.graphics.Rect
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


fun View?.show() {
    this?.visibility = View.VISIBLE
}

fun View?.visible(isVisible: Boolean) {
    this?.visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View?.hide() {
    this?.visibility = View.GONE
}

fun View?.invisible() {
    this?.visibility = View.INVISIBLE
}

fun View?.isVisible(): Boolean {
    return this?.visibility == View.VISIBLE
}

fun View?.isVisibleRect(scrollView: NestedScrollView): Boolean {
    val rect = Rect()
    scrollView.getHitRect(rect)
    this?.getLocalVisibleRect(rect)
    return rect.top >= 0
}

fun TextView?.setTextColorEx(@ColorRes id: Int) {
    this?.setTextColor(ContextCompat.getColor(this.context, id))
}

fun View?.setBackgroundColorEx(@ColorRes id: Int) {
    this?.background?.setTint(ContextCompat.getColor(this.context, id))
}

fun ImageView?.setImageTintColorEx(@ColorRes id: Int) {
    this?.setColorFilter(ContextCompat.getColor(this.context, id))
}

fun <T> RecyclerView.Adapter<*>.autoNotify(
    oldList: List<T>,
    newList: List<T>,
    compare: (T, T) -> Boolean
) {

    val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return compare(oldList[oldItemPosition], newList[newItemPosition])
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size
    })

    diff.dispatchUpdatesTo(this)
}