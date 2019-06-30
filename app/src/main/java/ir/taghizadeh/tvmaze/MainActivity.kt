package ir.taghizadeh.tvmaze

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import ir.taghizadeh.tvmaze.extentions.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var navController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            setUpNavigationBar()
    }

    private fun setUpNavigationBar() {

        val navGraphIds = listOf(
            R.navigation.shows, R.navigation.people, R.navigation.networks
        )

        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.frame_main,
            intent = intent
        )

        controller.observe(this, Observer { setupActionBarWithNavController(it) })
        navController = controller
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController?.value?.navigateUp() ?: false
    }

    override fun onBackPressed() {
        if (navController?.value?.popBackStack() != true)
            super.onBackPressed()
    }
}
