package ir.taghizadeh.deezer.data.repository


import androidx.lifecycle.LiveData
import ir.taghizadeh.deezer.data.db.TrackListDao
import ir.taghizadeh.deezer.data.db.entity.Track
import ir.taghizadeh.deezer.data.network.config.NetworkDataSource
import ir.taghizadeh.deezer.data.network.responses.ChartTracksResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TrackListRepositoryImpl(
    private val trackListDao: TrackListDao,
    private val networkDataSource: NetworkDataSource ) : TrackListRepository {

    init {
        networkDataSource.apply {
            downloadedTrackList.observeForever { newTrackList ->
                persistFetchedTrackList(newTrackList)
            }
        }
    }

    private fun persistFetchedTrackList(newTrackList: ChartTracksResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            trackListDao.upsert(newTrackList.data)
        }
    }

    override suspend fun getTrackList(): LiveData<List<Track>> {
        return withContext(Dispatchers.IO) {
            networkDataSource.fetchTrackList()
            return@withContext trackListDao.getTrackList()
        }
    }
}