package ir.taghizadeh.deezer.data.repository

import androidx.lifecycle.LiveData
import ir.taghizadeh.deezer.data.network.responses.ChartTracksResponse


interface TrackListRepository {
    suspend fun getTrackList(): LiveData<out ChartTracksResponse>
}