package ir.taghizadeh.tvmaze.view.showDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ir.taghizadeh.tvmaze.R
import kotlinx.android.synthetic.main.fragment_show_details.*

class ShowDetailsFragment : Fragment() {

    val args: ShowDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        initializeUi()
        handleNavigation()
    }

    private fun handleNavigation() {
        btn_show_people_details.setOnClickListener {
//            val action = ShowDetailsFragmentDirections.actionShowDetailsFragmentToPeopleDetails()
//            action.peopleId = text_show_people_title.text.toString()
//            findNavController().navigate(action)
        }
    }

    private fun initializeUi() {
        text_show_details_title.text = args.showId
    }
    private fun handleNavigation() {
        btn_people_details.setOnClickListener {
            val action = ShowDetailsFragmentDirections.showDetailsFragmentToPeopleDetailsFragment(text_people_title.text.toString())
            findNavController().navigate(action)
        }
        btn_network_details.setOnClickListener {
            val action = ShowDetailsFragmentDirections.showDetailsFragmentToNetworkDetailsFragment(text_network_title.text.toString())
            findNavController().navigate(action)
        }


    }

}
