package com.sushant.simpsoncharacterviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class SrcOptions(
//    val directory: String,
//    val is_fanon: Int,
//    val is_mediawiki: Int,
//    val is_wikipedia: Int,
//    val language: String,
//    val min_abstract_length: String,
//    val skip_abstract: Int,
//    val skip_abstract_paren: Int,
//    val skip_end: String,
//    val skip_icon: Int,
//    val skip_image_name: Int,
//    val skip_qr: String,
//    val source_skip: String,
//    val src_info: String
//)

class SrcOptions {

    @SerializedName("skip_qr")
    @Expose
    var skipQr: String? = null

    @SerializedName("skip_image_name")
    @Expose
    var skipImageName: Int? = null

    @SerializedName("skip_icon")
    @Expose
    var skipIcon: Int? = null

    @SerializedName("is_fanon")
    @Expose
    var isFanon: Int? = null

    @SerializedName("skip_end")
    @Expose
    var skipEnd: String? = null

    @SerializedName("language")
    @Expose
    var language: String? = null

    @SerializedName("skip_abstract_paren")
    @Expose
    var skipAbstractParen: Int? = null

    @SerializedName("skip_abstract")
    @Expose
    var skipAbstract: Int? = null

    @SerializedName("source_skip")
    @Expose
    var sourceSkip: String? = null

    @SerializedName("is_wikipedia")
    @Expose
    var isWikipedia: Int? = null

    @SerializedName("src_info")
    @Expose
    var srcInfo: String? = null

    @SerializedName("is_mediawiki")
    @Expose
    var isMediawiki: Int? = null

    @SerializedName("directory")
    @Expose
    var directory: String? = null

    @SerializedName("min_abstract_length")
    @Expose
    var minAbstractLength: String? = null

}