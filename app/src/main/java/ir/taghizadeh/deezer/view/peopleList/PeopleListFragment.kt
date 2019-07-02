package ir.taghizadeh.deezer.view.peopleList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.taghizadeh.deezer.R
import kotlinx.android.synthetic.main.fragment_people_list.*

class PeopleListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_people_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
    }

    private fun handleNavigation() {
        btn_people_details.setOnClickListener {
            val action = PeopleListFragmentDirections.peopleListFragmentToPeopleDetailsFragment(text_people_title.text.toString())
            findNavController().navigate(action)
        }
    }

}
