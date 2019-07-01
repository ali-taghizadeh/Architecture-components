package ir.taghizadeh.tvmaze.view.networkDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ir.taghizadeh.tvmaze.R
import ir.taghizadeh.tvmaze.view.peopleDetails.PeopleDetailsFragmentDirections
import kotlinx.android.synthetic.main.fragment_network_details.*
import kotlinx.android.synthetic.main.fragment_network_details.btn_show_details
import kotlinx.android.synthetic.main.fragment_network_details.text_show_title
import kotlinx.android.synthetic.main.fragment_people_details.*

class NetworkDetailsFragment : Fragment() {

    private val args: NetworkDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_network_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        initializeUi()
    }

    private fun initializeUi() {
        text_network_details_title.text = getString(R.string.network_details, args.networkId)
    }

    private fun handleNavigation() {
        btn_show_details.setOnClickListener {
            val action =
                NetworkDetailsFragmentDirections.networkDetailsFragmentToShowDetailsFragment(text_show_title.text.toString())
            findNavController().navigate(action)
        }
    }

}
