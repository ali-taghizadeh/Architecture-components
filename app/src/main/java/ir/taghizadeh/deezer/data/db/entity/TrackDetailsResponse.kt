package ir.taghizadeh.deezer.data.db.entity
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import ir.taghizadeh.deezer.data.db.typeConverter.ArtistTypeTypeConverter
import ir.taghizadeh.deezer.data.network.responses.general.Album
import ir.taghizadeh.deezer.data.network.responses.general.Artist

//@Entity(tableName = "track_details")
//@TypeConverters(ArtistTypeTypeConverter::class)
data class TrackDetailsResponse(
    val album: Album,
    @Embedded(prefix = "artist_")
    val artist: Artist,
    val bpm: Double,
    val contributors: List<Artist>,
    @SerializedName("disk_number")
    val diskNumber: Int,
    val duration: String,
    @SerializedName("explicit_content_cover")
    val explicitContentCover: Int,
    @SerializedName("explicit_content_lyrics")
    val explicitContentLyrics: Int,
    @SerializedName("explicit_lyrics")
    val explicitLyrics: Boolean,
    val id: String,
    val link: String,
    val preview: String,
    val rank: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    @SerializedName("title_short")
    val titleShort: String,
    val type: String
)
