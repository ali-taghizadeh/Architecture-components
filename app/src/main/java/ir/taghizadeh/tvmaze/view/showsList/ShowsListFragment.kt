package ir.taghizadeh.tvmaze.view.showsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.taghizadeh.tvmaze.R
import kotlinx.android.synthetic.main.fragment_shows_list.*

class ShowsListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_shows_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
    }

    private fun handleNavigation() {
        btn_show_details.setOnClickListener {
            val action = ShowsListFragmentDirections.showsListFragmentToShowDetailsFragment(text_show_title.text.toString())
            findNavController().navigate(action)
        }
    }

}
