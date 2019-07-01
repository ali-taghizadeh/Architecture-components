package ir.taghizadeh.tvmaze.view.networksList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.taghizadeh.tvmaze.R
import kotlinx.android.synthetic.main.fragment_networks_list.*

class NetworksListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_networks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
    }

    private fun handleNavigation() {
        btn_network_details.setOnClickListener {
            val action = NetworksListFragmentDirections.networkListFragmentToNetworkDetailsFragment(text_network_title.text.toString())
            findNavController().navigate(action)
        }
    }

}
