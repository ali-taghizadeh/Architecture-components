package ir.taghizadeh.tvmaze.view.peopleDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ir.taghizadeh.tvmaze.R
import kotlinx.android.synthetic.main.fragment_people_details.*

class PeopleDetailsFragment : Fragment() {

    private val args: PeopleDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_people_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        initializeUi()
    }

    private fun handleNavigation() {
        btn_people_show_details.setOnClickListener {
            val action = PeopleDetailsFragmentDirections.actionPeopleDetailsFragmentToShowDetails()
            action.showId = text_people_show_title.text.toString()
            findNavController().navigate(action)
        }
    }

    private fun initializeUi() {
        text_people_details_title.text = args.peopleId
    }

}
