package com.omrobbie.footballclub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemData(val image: Int?, val name: String?, val desc: String?): Parcelable