package com.example.musici.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musici.R
import com.example.musici.data.model.SearchAlbum
import com.example.musici.data.model.SearchTrack
import kotlinx.android.synthetic.main.item_search_album.view.*
import kotlinx.android.synthetic.main.item_search_tracks.view.*

class AlbumsSearchAdapter: RecyclerView.Adapter<AlbumsSearchAdapter.AlbumsSearchAdapterVh>() {

    private val data = arrayListOf<SearchAlbum>()

    fun setData(list: List<SearchAlbum>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()

    }

    fun clear(){
        data.clear()
        notifyDataSetChanged()
    }

    class AlbumsSearchAdapterVh (view: View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsSearchAdapterVh {
        return AlbumsSearchAdapterVh(
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_album, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AlbumsSearchAdapterVh, position: Int) {
        holder.itemView.tv_album_search_name.text = data[position].name
        holder.itemView.tv_album_search_artist.text = data[position].artist

        Glide
            .with(holder.itemView.context)
            .load("https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png" )
            .centerCrop()
            .placeholder(android.R.color.darker_gray)
            .into(holder.itemView.iv_album_search);

    }

    override fun getItemCount(): Int {
      return data.size
    }
}