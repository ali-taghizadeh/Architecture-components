package ir.taghizadeh.deezer.data.network.services

import ir.taghizadeh.deezer.data.network.responses.ChartAlbumsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

//https://api.deezer.com/chart/0/albums

interface ChartAlbumsService {
    @GET("chart/0/albums")
    fun getChartAlbums(): Deferred<ChartAlbumsResponse>
}