package ir.taghizadeh.deezer.data.repository


import androidx.lifecycle.LiveData
import ir.taghizadeh.deezer.data.network.config.NetworkDataSource
import ir.taghizadeh.deezer.data.network.responses.ChartTracksResponse
import ir.taghizadeh.deezer.data.network.responses.TrackDetailsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TrackListRepositoryImpl( networkDataSource: NetworkDataSource ) : TrackListRepository {

    init {
        networkDataSource.apply {
            downloadedTrackList.observeForever { newTrackList ->
                persistFetchedTrackList(newTrackList)
            }
        }
    }

    private fun persistFetchedTrackList(newTrackList: TrackDetailsResponse) {
        GlobalScope.launch(Dispatchers.IO) {}
    }

    override suspend fun getTrackList(): LiveData<out ChartTracksResponse> {
        return withContext(Dispatchers.IO) {
            initWeatherData()
            return@withContext if (metric) currentWeatherDao.getWeatherMetric()
            else currentWeatherDao.getWeatherImperial()
        }
    }
}