package ir.taghizadeh.deezer.view.artistDetails

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
import ir.taghizadeh.deezer.data.network.services.ArtistDetailsService
import ir.taghizadeh.deezer.utils.NoConnectivityException
import kotlinx.android.synthetic.main.fragment_artist_details.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await

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
        val apiService = ApiClient.buildService(activity!!, ArtistDetailsService::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            try {
                apiService.getArtistDetails("27").await()
            } catch (e: NoConnectivityException) {
                Toast.makeText(activity, getString(R.string.message_error_no_connection), Toast.LENGTH_LONG).show()
            }
        }
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
        btn_album_details.setOnClickListener {
            val action =
                ArtistDetailsFragmentDirections.artistDetailsFragmentToAlbumDetailsFragment(text_album_title.text.toString())
            findNavController().navigate(action)
        }

    }

}
