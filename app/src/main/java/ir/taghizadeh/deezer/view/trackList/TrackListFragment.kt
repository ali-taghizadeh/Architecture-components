package ir.taghizadeh.deezer.view.trackList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import ir.taghizadeh.deezer.R
import ir.taghizadeh.deezer.view.base.ScopedFragment
import kotlinx.android.synthetic.main.fragment_track_list.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class TrackListFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()

    private val viewModelFactory: TrackListViewModelFactory by instance()
    private lateinit var viewModel: TrackListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_track_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(TrackListViewModel::class.java)
        bindUI()
    }

    private fun bindUI() = launch {
        val trackList = viewModel.trackList.await()
        trackList.observe(this@TrackListFragment, Observer {
            if (it == null) return@Observer
            Log.e("Response", it[0].title)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
    }

    private fun handleNavigation() {
        btn_track_details.setOnClickListener {
            val action =
                TrackListFragmentDirections.trackListFragmentToTrackDetailsFragment(text_track_title.text.toString())
            findNavController().navigate(action)
        }
    }

}
