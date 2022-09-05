package com.huda.furnituretask.interfaces

import android.os.Parcelable

interface OnAdapterItemClickHandler {
    fun onItemClicked(itemId: Int?, type: String)
}