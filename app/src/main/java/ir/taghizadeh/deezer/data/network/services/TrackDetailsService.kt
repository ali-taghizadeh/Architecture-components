package ir.taghizadeh.deezer.data.network.services

import ir.taghizadeh.deezer.data.network.responses.TrackDetailsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

//https://api.deezer.com/track/3135556

interface TrackDetailsService {
    @GET("track/{id}")
    fun getTrackDetails(@Path("id") trackId: String): Deferred<TrackDetailsResponse>
}