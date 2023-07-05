package com.sushant.simpsoncharacterviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class SimpsonsModel(
//    val Abstract: String,
//    val AbstractSource: String,
//    val AbstractText: String,
//    val AbstractURL: String,
//    val Answer: String,
//    val AnswerType: String,
//    val Definition: String,
//    val DefinitionSource: String,
//    val DefinitionURL: String,
//    val Entity: String,

//    val Heading: String,
//    val Image: String,
//    val ImageHeight: Int,
//    val ImageIsLogo: Int,
//    val ImageWidth: Int,
//    val Infobox: String,
//    val Redirect: String,
//    val RelatedTopics: List<RelatedTopic>,
//    val Results: List<Any>,
//    val Type: String,
//    val meta: Meta
//)

class SimpsonsModel {

    @SerializedName("Abstract")
    @Expose
    var abstract: String? = null

    @SerializedName("AbstractSource")
    @Expose
    var abstractSource: String? = null

    @SerializedName("AbstractText")
    @Expose
    var abstractText: String? = null

    @SerializedName("AbstractURL")
    @Expose
    var abstractURL: String? = null

    @SerializedName("Answer")
    @Expose
    var answer: String? = null

    @SerializedName("AnswerType")
    @Expose
    var answerType: String? = null

    @SerializedName("Definition")
    @Expose
    var definition: String? = null

    @SerializedName("DefinitionSource")
    @Expose
    var definitionSource: String? = null

    @SerializedName("DefinitionURL")
    @Expose
    var definitionURL: String? = null

    @SerializedName("Entity")
    @Expose
    var entity: String? = null

    @SerializedName("Heading")
    @Expose
    var heading: String? = null

    @SerializedName("Image")
    @Expose
    var image: String? = null

    @SerializedName("ImageHeight")
    @Expose
    var imageHeight: String? = null

    @SerializedName("ImageIsLogo")
    @Expose
    var imageIsLogo: String? = null

    @SerializedName("ImageWidth")
    @Expose
    var imageWidth: String? = null

    @SerializedName("Infobox")
    @Expose
    var infobox: String? = null

    @SerializedName("Redirect")
    @Expose
    var redirect: String? = null

    @SerializedName("RelatedTopics")
    @Expose
    var relatedTopics: List<RelatedTopic>? = null

    @SerializedName("Results")
    @Expose
    var results: List<Any>? = null

    @SerializedName("meta")
    @Expose
    var meta: Meta? = null


}