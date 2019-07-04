package ir.taghizadeh.deezer.data.network.responses
import com.google.gson.annotations.SerializedName
import ir.taghizadeh.deezer.data.network.responses.general.Album
import ir.taghizadeh.deezer.data.network.responses.general.Artist


data class TrackDetailsResponse(
    @SerializedName("album")
    val album: Album,
    @SerializedName("artist")
    val artist: Artist,
    @SerializedName("available_countries")
    val availableCountries: List<String>,
    @SerializedName("bpm")
    val bpm: Double,
    @SerializedName("contributors")
    val contributors: List<Artist>,
    @SerializedName("disk_number")
    val diskNumber: Int,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("explicit_content_cover")
    val explicitContentCover: Int,
    @SerializedName("explicit_content_lyrics")
    val explicitContentLyrics: Int,
    @SerializedName("explicit_lyrics")
    val explicitLyrics: Boolean,
    @SerializedName("gain")
    val gain: Double,
    @SerializedName("id")
    val id: String,
    @SerializedName("isrc")
    val isrc: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("preview")
    val preview: String,
    @SerializedName("rank")
    val rank: String,
    @SerializedName("readable")
    val readable: Boolean,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("share")
    val share: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("title_short")
    val titleShort: String,
    @SerializedName("title_version")
    val titleVersion: String,
    @SerializedName("track_position")
    val trackPosition: Int,
    @SerializedName("type")
    val type: String
)
