package ir.taghizadeh.deezer.data.network.responses
import com.google.gson.annotations.SerializedName


data class ChartTracksResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("total")
    val total: Int
)

data class Data(
    @SerializedName("album")
    val album: Album,
    @SerializedName("artist")
    val artist: Artist,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("explicit_content_cover")
    val explicitContentCover: Int,
    @SerializedName("explicit_content_lyrics")
    val explicitContentLyrics: Int,
    @SerializedName("explicit_lyrics")
    val explicitLyrics: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("position")
    val position: Int,
    @SerializedName("preview")
    val preview: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("title_short")
    val titleShort: String,
    @SerializedName("title_version")
    val titleVersion: String,
    @SerializedName("type")
    val type: String
)

data class Artist(
    @SerializedName("id")
    val id: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("picture_big")
    val pictureBig: String,
    @SerializedName("picture_medium")
    val pictureMedium: String,
    @SerializedName("picture_small")
    val pictureSmall: String,
    @SerializedName("picture_xl")
    val pictureXl: String,
    @SerializedName("radio")
    val radio: Boolean,
    @SerializedName("tracklist")
    val tracklist: String,
    @SerializedName("type")
    val type: String
)

data class Album(
    @SerializedName("cover")
    val cover: String,
    @SerializedName("cover_big")
    val coverBig: String,
    @SerializedName("cover_medium")
    val coverMedium: String,
    @SerializedName("cover_small")
    val coverSmall: String,
    @SerializedName("cover_xl")
    val coverXl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("tracklist")
    val tracklist: String,
    @SerializedName("type")
    val type: String
)