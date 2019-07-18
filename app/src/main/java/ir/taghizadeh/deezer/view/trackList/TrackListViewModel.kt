package ir.taghizadeh.deezer.view.trackList

import androidx.lifecycle.ViewModel
import ir.taghizadeh.deezer.data.repository.TrackListRepository
import ir.taghizadeh.deezer.utils.lazyDeferred

class TrackListViewModel(private val trackListRepository: TrackListRepository) : ViewModel() {
    val trackList by lazyDeferred {
        trackListRepository.getTrackList()
    }
}
