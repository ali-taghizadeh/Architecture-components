package ir.taghizadeh.deezer.view.trackList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.taghizadeh.deezer.R
import kotlinx.android.synthetic.main.fragment_track_list.*

class TrackListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_track_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
    }

    private fun handleNavigation() {
        btn_track_details.setOnClickListener {
            val action = TrackListFragmentDirections.trackListFragmentToTrackDetailsFragment(text_track_title.text.toString())
            findNavController().navigate(action)
        }
    }

}