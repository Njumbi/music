package com.example.musici.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musici.R
import com.example.musici.data.ApiClient
import com.example.musici.data.model.SearchTrack
import com.example.musici.data.model.SearchTracks
import com.example.musici.ui.adapters.TracksSearchAdapter
import kotlinx.android.synthetic.main.activity_tracks_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TracksSearchActivity : AppCompatActivity() {
    private lateinit var searchAdapter: TracksSearchAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracks_search)



        setSupportActionBar(toolbar_searchTracks)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = " "

        et_search_track.requestFocus()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        searchAdapter = TracksSearchAdapter()
        rv_series_search.layoutManager = GridLayoutManager(this, 3)
        rv_series_search.adapter = searchAdapter

        et_search_track.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if (it.length > 3) {
                        searchTrack(s.toString())
                    } else {
                        searchAdapter.clear()
                    }

                } ?: kotlin.run {
                    searchAdapter.clear()
                }

            }

        })
    }

    private fun searchTrack(track: String) {
        val call = ApiClient()?.service?.searchTopTracks(track)
        call?.enqueue(object : Callback<SearchTracks> {
            override fun onResponse(call: Call<SearchTracks>, response: Response<SearchTracks>) {
                if (response.isSuccessful) {
                    val list = response.body()?.results?.trackmatches?.track
                    if (list.isNullOrEmpty()) {
                        tv_series_search_no_data.visibility = View.VISIBLE
                    } else {
                       searchAdapter.setData(list as List<SearchTrack>)
                        tv_series_search_no_data.visibility = View.GONE
                    }

                } else {
                    Toast.makeText(
                        this@TracksSearchActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

            override fun onFailure(call: Call<SearchTracks>, t: Throwable) {
                Toast.makeText(this@TracksSearchActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}