package com.stanislav.aonetestassignment.models

import android.os.Parcel
import android.os.Parcelable
import com.stanislav.aonetestassignment.models.TeamBasic

data class TeamStanding(
        val position: Int,
        val team: TeamBasic,
        val playedGames: Int,
        val won: Int,
        val draw: Int,
        val lost: Int,
        val points: Int,
        val goalsFor: Int,
        val goalsAgainst: Int,
        val goalDifference: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readParcelable(TeamBasic::class.java.classLoader),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(position)
        parcel.writeParcelable(team, flags)
        parcel.writeInt(playedGames)
        parcel.writeInt(won)
        parcel.writeInt(draw)
        parcel.writeInt(lost)
        parcel.writeInt(points)
        parcel.writeInt(goalsFor)
        parcel.writeInt(goalsAgainst)
        parcel.writeInt(goalDifference)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TeamStanding> {
        override fun createFromParcel(parcel: Parcel): TeamStanding {
            return TeamStanding(parcel)
        }

        override fun newArray(size: Int): Array<TeamStanding?> {
            return arrayOfNulls(size)
        }
    }
}