package ir.taghizadeh.deezer.data.network.responses.general

import com.google.gson.annotations.SerializedName


data class Artist(
    val id: Int,
    val link: String,
    val name: String,
    val picture: String,
    @SerializedName("picture_xl")
    val pictureXl: String,
    @SerializedName("tracklist")
    val tracklist: String,
    @SerializedName("type")
    val type: String
)