package ir.taghizadeh.deezer.data.network.config


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.taghizadeh.deezer.data.network.responses.ChartTracksResponse
import ir.taghizadeh.deezer.data.network.services.ChartTracksService
import retrofit2.await
import java.io.IOException


class NetworkDataSourceImpl : NetworkDataSource {

    private val _downloadedTrackList = MutableLiveData<ChartTracksResponse>()
    override val downloadedTrackList: LiveData<ChartTracksResponse>
        get() = _downloadedTrackList

    override suspend fun fetchTrackList() {
        try {
            val fetchedTrackList =
                ApiClient.buildService(ChartTracksService::class.java)
                    .getChartTracks().await()
            _downloadedTrackList.postValue(fetchedTrackList)

        } catch (e: IOException) {
            Log.e("Connectivity", "No internet connection.", e)
        }
    }
}