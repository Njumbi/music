package com.example.musici.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musici.R
import com.example.musici.data.model.Results
import com.example.musici.data.model.SearchTrack
import kotlinx.android.synthetic.main.item_search_tracks.view.*
import kotlinx.android.synthetic.main.item_top_tracks.view.*

class TracksSearchAdapter : RecyclerView.Adapter<TracksSearchAdapter.TracksSearchAdapterVh>(){

    private val data = arrayListOf<SearchTrack>()

    fun setData(list: List<SearchTrack>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()

    }

    fun clear(){
        data.clear()
        notifyDataSetChanged()
    }


    class TracksSearchAdapterVh(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksSearchAdapterVh {
     return TracksSearchAdapterVh(
         LayoutInflater.from(parent.context).inflate(R.layout.item_search_tracks,parent,false)
     )
    }

    override fun onBindViewHolder(holder: TracksSearchAdapterVh, position: Int) {
       holder.itemView.tv_track_search_name.text = data[position].name
        holder.itemView.tv_track_search_artist.text = data[position].artist

        Glide
            .with(holder.itemView.context)
            .load("https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png" )
            .centerCrop()
            .placeholder(android.R.color.darker_gray)
            .into(holder.itemView.iv_track_search);

    }

    override fun getItemCount(): Int {
        return data.size
    }
}