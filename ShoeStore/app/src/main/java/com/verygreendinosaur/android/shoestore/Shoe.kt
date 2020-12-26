package com.verygreendinosaur.android.shoestore

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(val name: String, val company: String, val size: Double, val description: String): Parcelable {

    public fun formattedForDisplay(): String {
        return "$name ($size)\n$company - $description\n"
    }

}