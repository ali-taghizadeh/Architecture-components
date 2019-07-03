package ir.taghizadeh.deezer.data.network.responses
import com.google.gson.annotations.SerializedName
import ir.taghizadeh.deezer.data.network.responses.general.Artist


data class ChartArtistsResponse(
    @SerializedName("data")
    val data: List<Artist>,
    @SerializedName("total")
    val total: Int
)

