package com.example.musici.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musici.R
import com.example.musici.data.model.TopArtist
import kotlinx.android.synthetic.main.item_top_artists.view.*
import kotlinx.android.synthetic.main.item_top_tracks.view.*

class TopArtistAdapter : RecyclerView.Adapter<TopArtistAdapter.TopArtistAdapterVh>() {

    private var data = arrayListOf<TopArtist>()

    fun setData(list: List<TopArtist>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    class TopArtistAdapterVh(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopArtistAdapterVh {
        return TopArtistAdapterVh(
            LayoutInflater.from(parent.context).inflate(R.layout.item_top_artists, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopArtistAdapterVh, position: Int) {
        holder.itemView.tv_topArtists_name.text = data[position].name



        Glide
            .with(holder.itemView.context)
            .load("https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png" )
            .centerCrop()
            .placeholder(android.R.color.darker_gray)
            .into(holder.itemView.iv_top_artists);

    }

    override fun getItemCount(): Int {
        return data.size
    }


}


