package ir.taghizadeh.deezer.view.albumDetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ir.taghizadeh.deezer.R
import ir.taghizadeh.deezer.data.network.ApiClient
import ir.taghizadeh.deezer.data.network.services.AlbumDetailsService
import ir.taghizadeh.deezer.data.network.services.ChartAlbumsService
import kotlinx.android.synthetic.main.fragment_album_details.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AlbumDetailsFragment : Fragment() {

    private val args: AlbumDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        initializeUi()
        val apiService = ApiClient.buildService(AlbumDetailsService::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            val albumDetails = apiService.getAlbumDetails("302127").await()
            Log.d("AlbumDetailsResponse: ", albumDetails.toString())
        }
    }

    private fun initializeUi() {
        text_album_details_title.text = getString(R.string.album_details, args.albumId)
    }

    private fun handleNavigation() {
        btn_track_details.setOnClickListener {
            val action =
                AlbumDetailsFragmentDirections.albumDetailsFragmentToTrackDetailsFragment(text_track_title.text.toString())
            findNavController().navigate(action)
        }
        btn_artist_details.setOnClickListener {
            val action =
                AlbumDetailsFragmentDirections.albumDetailsFragmentToArtistDetailsFragment(text_artist_title.text.toString())
            findNavController().navigate(action)
        }
    }

}
