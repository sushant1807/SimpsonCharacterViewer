package com.sushant.simpsoncharacterviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class Developer(
//    val name: String,
//    val type: String,
//    val url: String
//)

class Developer {

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

}
