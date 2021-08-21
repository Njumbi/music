package com.example.musici.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musici.R
import com.example.musici.data.model.Image
import com.example.musici.data.model.Track
import com.example.musici.data.model.Tracks
import kotlinx.android.synthetic.main.item_top_tracks.view.*


class TopTracksAdapter : RecyclerView.Adapter<TopTracksAdapter.TopTracksVh>(){
     private  var data = arrayListOf<Track>()

    fun setData(list: List<Track>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    class TopTracksVh(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopTracksVh {
        return TopTracksVh(
            LayoutInflater.from(parent.context).inflate(R.layout.item_top_tracks,parent,false)
        )
    }

    override fun onBindViewHolder(holder: TopTracksVh, position: Int) {
            holder.itemView.tv_topTracks_name.text = data[position].name
            holder.itemView.tv_topTracks_artist.text =data[position]?.artist?.name
        holder.itemView.iv_top_tracks.setOnClickListener {

        }

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




