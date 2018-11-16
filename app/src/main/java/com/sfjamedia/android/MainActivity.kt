package com.sfjamedia.android

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity(), LinksFragment.OnFragmentInteractionListener,
        ContactFragment.OnFragmentInteractionListener,
        FoodieFragment.OnFragmentInteractionListener,
        HomeFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        super.onCreate(savedInstanceState)
        val nightModeFlags = this.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (nightModeFlags) {
            Configuration.UI_MODE_NIGHT_NO -> View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        bottom_nav.setupWithNavController(Navigation.findNavController(this, R.id.nav_host_fragment))
    }

    override fun onFragmentInteraction(title: String) {
        supportActionBar!!.title = title
    }
}
