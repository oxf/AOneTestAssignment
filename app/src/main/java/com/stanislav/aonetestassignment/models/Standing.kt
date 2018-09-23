package com.stanislav.aonetestassignment.models

import android.os.Parcel
import android.os.Parcelable

data class Standing(
     val stage: String,
     val type: String,
     val group: String?,
     val table: List<TeamStanding>
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(TeamStanding)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(stage)
        parcel.writeString(type)
        parcel.writeString(group)
        parcel.writeTypedList(table)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Standing> {
        override fun createFromParcel(parcel: Parcel): Standing {
            return Standing(parcel)
        }

        override fun newArray(size: Int): Array<Standing?> {
            return arrayOfNulls(size)
        }
    }

}