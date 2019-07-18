package ir.taghizadeh.deezer.data.network.config

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.taghizadeh.deezer.data.network.responses.TrackDetailsResponse
import ir.taghizadeh.deezer.data.network.services.ChartTracksService


class NetworkDataSourceImpl(private val apiClient : ApiClient) : NetworkDataSource {

    private val _downloadedTrackList = MutableLiveData<TrackDetailsResponse>()
    override val downloadedTrackList: LiveData<TrackDetailsResponse>
        get() = _downloadedTrackList

    override suspend fun fetchTrackList() {
        try {
            val apiService = ApiClient.buildService(activity!!, ChartTracksService::class.java)
            val fetchedTrackList = apiClient.buildService()
        }
    }
}