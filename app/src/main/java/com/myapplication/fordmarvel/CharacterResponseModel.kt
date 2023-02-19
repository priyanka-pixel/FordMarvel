package com.myapplication.fordmarvel


data class CharacterResponseModL(
    val data: Data
)
data class Data(
    var results: List<Result>
)
data class Result(

    val id: Int,
    val name: String,
    val resourceURI: String,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)
data class Thumbnail(
    val extension: String,
    val path: String
)
data class Url(
    val type: String,
    val url: String
)
