package com.stanislav.aonetestassignment.models

import android.os.Parcel
import android.os.Parcelable

data class TeamBasic(
    val id: Long,
    val name: String,
    val crestUrl: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(crestUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TeamBasic> {
        override fun createFromParcel(parcel: Parcel): TeamBasic {
            return TeamBasic(parcel)
        }

        override fun newArray(size: Int): Array<TeamBasic?> {
            return arrayOfNulls(size)
        }
    }
}