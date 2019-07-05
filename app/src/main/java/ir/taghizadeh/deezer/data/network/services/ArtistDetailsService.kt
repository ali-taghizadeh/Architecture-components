package ir.taghizadeh.deezer.data.network.services

import ir.taghizadeh.deezer.data.network.responses.ArtistDetailsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//https://api.deezer.com/artist/27

interface ArtistDetailsService {
    @GET("artist/{id}")
    fun getArtistDetails(@Path("id") artistId: String): Call<ArtistDetailsResponse>
}