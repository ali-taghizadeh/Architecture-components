package ir.taghizadeh.deezer.data.network.responses
import com.google.gson.annotations.SerializedName
import ir.taghizadeh.deezer.data.network.responses.general.Album
import ir.taghizadeh.deezer.data.network.responses.general.Artist


data class ChartAlbumsResponse(
    @SerializedName("data")
    val data: List<Album>,
    @SerializedName("total")
    val total: Int
)

