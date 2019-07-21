package ir.taghizadeh.deezer.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import ir.taghizadeh.deezer.data.db.typeConverter.ArtistTypeTypeConverter
import ir.taghizadeh.deezer.data.network.responses.general.Album
import ir.taghizadeh.deezer.data.network.responses.general.Artist


@Entity(tableName = "track_list")
@TypeConverters(ArtistTypeTypeConverter::class)
data class Track(

    @Embedded(prefix = "album_")
    val album: Album,
    @Embedded(prefix = "artist_")
    val artist: Artist,
    val duration: Int,
    @SerializedName("explicit_content_cover")
    val explicitContentCover: Int,
    val id: Int,
    val rank: Int,
    val title: String

){
    @PrimaryKey(autoGenerate = true)
    var roomId: Int = 0
}