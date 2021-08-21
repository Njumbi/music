package com.example.musici.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musici.R
import com.example.musici.data.ApiClient
import com.example.musici.data.model.*
import com.example.musici.ui.adapters.AlbumsSearchAdapter
import com.example.musici.ui.adapters.TracksSearchAdapter
import kotlinx.android.synthetic.main.activity_album_search.*
import kotlinx.android.synthetic.main.activity_tracks_search.*
import kotlinx.android.synthetic.main.fragment_albums.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumSearchActivity : AppCompatActivity() {
    lateinit var searchAlbumAdapter: AlbumsSearchAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_search)

        setSupportActionBar(toolbar_searchAlbums)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = " "

        et_search_album.requestFocus()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        searchAlbumAdapter = AlbumsSearchAdapter()
        rv_album_search.layoutManager = GridLayoutManager(this, 3)
        rv_album_search.adapter = searchAlbumAdapter

        et_search_album.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if (it.length > 3) {
                        searchAlbum(s.toString())
                    } else {
                        searchAlbumAdapter.clear()
                    }

                } ?: kotlin.run {
                    searchAlbumAdapter.clear()
                }

            }

        })
    }

    private fun searchAlbum(track: String) {
        val call = ApiClient()?.service?.searchTopAlbums(track)
        call?.enqueue(object : Callback<SearchAlbums> {
            override fun onResponse(call: Call<SearchAlbums>, response: Response<SearchAlbums>) {
                if (response.isSuccessful) {
                    val list = response.body()?.results?.trackmatches?.track
                    if (list.isNullOrEmpty()) {
                        tv_search_no_data_album.visibility = View.VISIBLE
                        Log.d("This is null", list.toString())
                    } else {
                        searchAlbumAdapter.setData(list as List<SearchAlbum>)
                        tv_search_no_data_album.visibility = View.GONE
                        Log.d("This is full", list.toString())
                    }

                } else {
                    Toast.makeText(
                        this@AlbumSearchActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

            override fun onFailure(call: Call<SearchAlbums>, t: Throwable) {
                Toast.makeText(this@AlbumSearchActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }


}