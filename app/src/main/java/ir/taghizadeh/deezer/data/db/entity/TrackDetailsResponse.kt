package ir.taghizadeh.deezer.data.db.entity
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import ir.taghizadeh.deezer.data.db.typeConverter.ArtistTypeTypeConverter
import ir.taghizadeh.deezer.data.network.responses.general.Album
import ir.taghizadeh.deezer.data.network.responses.general.Artist

@Entity(tableName = "track_list")
@TypeConverters(ArtistTypeTypeConverter::class)
data class TrackDetailsResponse(

    val album: Album,
    @Embedded(prefix = "artist_")
    val artist: Artist,
    val bpm: Double,
    val contributors: List<Artist>,
    val diskNumber: Int,
    val duration: String,
    val explicitContentCover: Int,
    val explicitContentLyrics: Int,
    val explicitLyrics: Boolean,
    val id: String,
    val link: String,
    val preview: String,
    val rank: String,
    val releaseDate: String,
    val title: String,
    val titleShort: String,
    val type: String
)
