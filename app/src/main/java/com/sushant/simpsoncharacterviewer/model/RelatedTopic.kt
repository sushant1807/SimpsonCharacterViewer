package com.sushant.simpsoncharacterviewer.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class RelatedTopic(
//    val FirstURL: String,
//    val Icon: Icon,
//    val Result: String,
//    val Text: String
//)

class RelatedTopic() : Parcelable {

    @SerializedName("Text")
    @Expose
    var text: String? = null

    @SerializedName("Icon")
    @Expose
    var icon: Icon? = null

    @SerializedName("FirstURL")
    @Expose
    var firstURL: String? = null

    @SerializedName("Result")
    @Expose
    var result: String? = null

    constructor(parcel: Parcel) : this() {
        text = parcel.readString()
        firstURL = parcel.readString()
        result = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(text)
        parcel.writeString(firstURL)
        parcel.writeString(result)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RelatedTopic> {
        override fun createFromParcel(parcel: Parcel): RelatedTopic {
            return RelatedTopic(parcel)
        }

        override fun newArray(size: Int): Array<RelatedTopic?> {
            return arrayOfNulls(size)
        }
    }

}