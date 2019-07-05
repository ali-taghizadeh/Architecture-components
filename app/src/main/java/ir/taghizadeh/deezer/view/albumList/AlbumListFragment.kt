package ir.taghizadeh.deezer.view.albumList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.taghizadeh.deezer.R
import ir.taghizadeh.deezer.data.network.config.ApiClient
import ir.taghizadeh.deezer.data.network.services.ChartAlbumsService
import kotlinx.android.synthetic.main.fragment_album_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await

class AlbumListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        val apiService = ApiClient.buildService(ChartAlbumsService::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            try {
                apiService.getChartAlbums().await()
            } catch (e: Throwable) {
                Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun handleNavigation() {
        btn_album_details.setOnClickListener {
            val action =
                AlbumListFragmentDirections.albumListFragmentToAlbumDetailsFragment(text_album_title.text.toString())
            findNavController().navigate(action)
        }
    }

}
