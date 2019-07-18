package ir.taghizadeh.deezer.data.network.config

import androidx.lifecycle.LiveData
import ir.taghizadeh.deezer.data.network.responses.TrackDetailsResponse


interface NetworkDataSource {
    val downloadedTrackList: LiveData<TrackDetailsResponse>

    suspend fun fetchTrackList()

}