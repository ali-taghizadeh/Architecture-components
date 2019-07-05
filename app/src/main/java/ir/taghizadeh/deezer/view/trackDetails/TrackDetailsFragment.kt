package ir.taghizadeh.deezer.view.trackDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ir.taghizadeh.deezer.R
import ir.taghizadeh.deezer.data.network.config.ApiClient
import ir.taghizadeh.deezer.data.network.services.TrackDetailsService
import kotlinx.android.synthetic.main.fragment_track_details.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await

class TrackDetailsFragment : Fragment() {

    val args: TrackDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_track_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        initializeUi()
        val apiService = ApiClient.buildService(TrackDetailsService::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            try {
                apiService.getTrackDetails("3135556").await()
            } catch (e: Throwable) {
                Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initializeUi() {
        text_track_details_title.text = getString(R.string.track_details, args.trackId)
    }

    private fun handleNavigation() {
        btn_album_details.setOnClickListener {
            val action =
                TrackDetailsFragmentDirections.trackDetailsFragmentToAlbumDetailsFragment(text_album_title.text.toString())
            findNavController().navigate(action)
        }
        btn_artist_details.setOnClickListener {
            val action =
                TrackDetailsFragmentDirections.trackDetailsFragmentToArtistDetailsFragment(text_artist_title.text.toString())
            findNavController().navigate(action)
        }


    }

}
