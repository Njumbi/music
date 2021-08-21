package com.example.musici.ui

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.musici.R
import com.example.musici.ui.fragments.AlbumsFragment
import com.example.musici.ui.fragments.TopArtistsFragment
import com.example.musici.ui.fragments.TracksFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(TracksFragment())
        bottom_menu.setOnNavigationItemSelectedListener(this)

    }

    private fun loadFragment(frag: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_main_activity, frag)
            .commit()
        Log.d(TAG,"Main activity testing")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.tracks -> loadFragment(TracksFragment())
            R.id.albums -> loadFragment(AlbumsFragment())
            R.id.artists -> loadFragment(TopArtistsFragment())


        }
        return true
    }
}

