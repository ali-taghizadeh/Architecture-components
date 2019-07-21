package ir.taghizadeh.deezer.data.network.config

import androidx.lifecycle.LiveData
import ir.taghizadeh.deezer.data.network.responses.ChartTracksResponse


interface NetworkDataSource {
    val downloadedTrackList: LiveData<ChartTracksResponse>
    suspend fun fetchTrackList()
}