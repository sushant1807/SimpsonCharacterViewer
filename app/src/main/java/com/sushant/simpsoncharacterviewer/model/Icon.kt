package com.sushant.simpsoncharacterviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class Icon(
//    val Height: String,
//    val URL: String,
//    val Width: String
//)

class Icon {

    @SerializedName("Width")
    @Expose
    var width: String? = null

    @SerializedName("URL")
    @Expose
    var url: String? = null

    @SerializedName("Height")
    @Expose
    var height: String? = null

}