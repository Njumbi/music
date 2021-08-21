package com.example.musici.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musici.R
import com.example.musici.data.model.Album
import com.example.musici.data.model.Track
import kotlinx.android.synthetic.main.item_top_tracks.view.*

class TopAlbums: RecyclerView.Adapter<TopAlbums.TopAlbumsVh>(){
    private  var data = arrayListOf<Album>()

    fun setData(list: List<Album>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    class TopAlbumsVh(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopAlbumsVh {
        return TopAlbumsVh(
            LayoutInflater.from(parent.context).inflate(R.layout.item_top_tracks,parent,false)
        )
    }

    override fun onBindViewHolder(holder: TopAlbumsVh, position: Int) {
        holder.itemView.tv_topTracks_name.text = data[position].name
        holder.itemView.tv_topTracks_artist.text =data[position]?.artist?.name

        Glide
            .with(holder.itemView.context)
            .load("https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png" )
            .centerCrop()
            .placeholder(android.R.color.darker_gray)
            .into(holder.itemView.iv_top_tracks);



    }

    override fun getItemCount(): Int {
        return data.size

    }


}

