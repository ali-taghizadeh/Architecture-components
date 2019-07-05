package ir.taghizadeh.deezer.view.artistList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.taghizadeh.deezer.R
import ir.taghizadeh.deezer.data.network.ApiClient
import ir.taghizadeh.deezer.data.network.services.ChartArtistsService
import kotlinx.android.synthetic.main.fragment_artist_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await

class ArtistListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_artist_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        val apiService = ApiClient.buildService(ChartArtistsService::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            val chartArtists = apiService.getChartArtists().await()
            Log.d("ChartArtistsResponse: ", chartArtists.data.toString())
        }
    }

    private fun handleNavigation() {
        btn_artist_details.setOnClickListener {
            val action = ArtistListFragmentDirections.artistListFragmentToArtistDetailsFragment(text_artist_title.text.toString())
            findNavController().navigate(action)
        }
    }

}
