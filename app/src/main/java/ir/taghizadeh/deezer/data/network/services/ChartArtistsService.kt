package ir.taghizadeh.deezer.data.network.services

import ir.taghizadeh.deezer.data.network.responses.ChartArtistsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

//https://api.deezer.com/chart/0/artists

interface ChartArtistsService {
    @GET("chart/0/artists")
    fun getChartArtists(): Deferred<ChartArtistsResponse>
}