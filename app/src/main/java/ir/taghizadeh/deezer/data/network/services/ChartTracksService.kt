package ir.taghizadeh.deezer.data.network.services

import ir.taghizadeh.deezer.data.network.responses.ChartTracksResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

//https://api.deezer.com/chart/0/tracks

interface ChartTracksService {
    @GET("chart/0/tracks")
    fun getChartTracks(): Deferred<ChartTracksResponse>
}