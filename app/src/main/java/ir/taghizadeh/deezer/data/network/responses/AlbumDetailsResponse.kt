package ir.taghizadeh.deezer.data.network.responses
import com.google.gson.annotations.SerializedName
import ir.taghizadeh.deezer.data.network.responses.general.Artist
import ir.taghizadeh.deezer.data.network.responses.general.Genre


data class AlbumDetailsResponse(
    @SerializedName("artist")
    val artist: Artist,
    @SerializedName("available")
    val available: Boolean,
    @SerializedName("contributors")
    val contributors: List<Artist>,
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
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("explicit_content_cover")
    val explicitContentCover: Int,
    @SerializedName("explicit_content_lyrics")
    val explicitContentLyrics: Int,
    @SerializedName("explicit_lyrics")
    val explicitLyrics: Boolean,
    @SerializedName("fans")
    val fans: Int,
    @SerializedName("genre_id")
    val genreId: Int,
    @SerializedName("genres")
    val genres: Genres,
    @SerializedName("id")
    val id: String,
    @SerializedName("label")
    val label: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("nb_tracks")
    val nbTracks: Int,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("record_type")
    val recordType: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("share")
    val share: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("tracklist")
    val tracklist: String,
    @SerializedName("tracks")
    val tracks: Tracks,
    @SerializedName("type")
    val type: String,
    @SerializedName("upc")
    val upc: String
)

data class Genres(
    @SerializedName("data")
    val data: List<Genre>
)

data class Tracks(
    @SerializedName("data")
    val data: List<Tracks>
)

