package ir.taghizadeh.deezer.view.artistList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.taghizadeh.deezer.R
import kotlinx.android.synthetic.main.fragment_artist_list.*

class ArtistListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_artist_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
    }

    private fun handleNavigation() {
        btn_artist_details.setOnClickListener {
            val action = ArtistListFragmentDirections.artistListFragmentToArtistDetailsFragment(text_artist_title.text.toString())
            findNavController().navigate(action)
        }
    }

}
