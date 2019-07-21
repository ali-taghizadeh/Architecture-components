package ir.taghizadeh.deezer.data.repository

import androidx.lifecycle.LiveData
import ir.taghizadeh.deezer.data.db.entity.Track


interface TrackListRepository {
    suspend fun getTrackList(): LiveData<List<Track>>
}