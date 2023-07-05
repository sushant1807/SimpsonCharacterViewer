package com.sushant.simpsoncharacterviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class Maintainer(
//    val github: String
//)

class Maintainer {

    @SerializedName("github")
    @Expose
    var github: String? = null

}