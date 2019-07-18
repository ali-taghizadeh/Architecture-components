package ir.taghizadeh.deezer.view.trackList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.taghizadeh.deezer.data.repository.TrackListRepository

@Suppress("UNCHECKED_CAST")
class TrackListViewModelFactory( private val trackListRepository: TrackListRepository ) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TrackListViewModel(trackListRepository) as T
    }
}