package com.sfjamedia.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), LinksFragment.OnFragmentInteractionListener,
        ContactFragment.OnFragmentInteractionListener,
        FoodieFragment.OnFragmentInteractionListener,
        HomeFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        bottom_nav.setupWithNavController(Navigation.findNavController(this, R.id.nav_host_fragment))
    }

    override fun onFragmentInteraction(title: String) {
        supportActionBar!!.title = title
    }
}
