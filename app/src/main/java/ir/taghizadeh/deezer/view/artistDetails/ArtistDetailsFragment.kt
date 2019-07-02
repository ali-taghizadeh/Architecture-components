package ir.taghizadeh.deezer.view.artistDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ir.taghizadeh.deezer.R
import kotlinx.android.synthetic.main.fragment_artist_details.*
import kotlinx.android.synthetic.main.fragment_artist_details.text_track_title

class ArtistDetailsFragment : Fragment() {

    private val args: ArtistDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_artist_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        initializeUi()
    }

    private fun initializeUi() {
        text_artist_details_title.text = getString(R.string.artist_details, args.artistId)
    }

    private fun handleNavigation() {
        btn_track_details.setOnClickListener {
            val action =
                ArtistDetailsFragmentDirections.artistDetailsFragmentToTrackDetailsFragment(text_track_title.text.toString())
            findNavController().navigate(action)
        }
    }

}
