package ir.taghizadeh.deezer.data.network.services

import ir.taghizadeh.deezer.data.network.responses.AlbumDetailsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

//https://api.deezer.com/album/302127

interface AlbumDetailsService {
    @GET("album/{id}")
    fun getAlbumDetails(@Path("id") albumId: String): Deferred<AlbumDetailsResponse>
}