package ir.taghizadeh.tvmaze.view.networkDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import ir.taghizadeh.tvmaze.R
import kotlinx.android.synthetic.main.fragment_network_details.*

class NetworkDetailsFragment : Fragment() {

    private val args: NetworkDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_network_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUi()
    }

    private fun initializeUi() {
        text_network_details_title.text = args.networkId
    }

}
