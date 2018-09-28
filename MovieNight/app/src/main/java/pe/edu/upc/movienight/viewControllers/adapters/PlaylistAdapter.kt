package pe.edu.upc.movienight.viewControllers.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.playlist_item.view.*
import pe.edu.upc.movienight.R
import pe.edu.upc.movienight.models.Playlist
import pe.edu.upc.movienight.viewControllers.activities.MediaContensActivity

class PlaylistAdapter (var playlists: ArrayList<Playlist>, val context: Context) :
        RecyclerView.Adapter<PlaylistAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.playlist_item, parent, false))
    }

    override fun getItemCount(): Int {
        return playlists.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val playlist = playlists[position]
        holder.updateFrom(playlist)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val nameTextView = view.nameTextView
        val originalImageButton = view.originalImageButton
        val playlistLayout = view.playlistLayout

        fun updateFrom(playlist: Playlist){
            nameTextView.text = playlist.name
            originalImageButton.setImageResource(imageButtonFor(playlist.original!!))

            playlistLayout.setOnClickListener {view ->
                val context= view.context
                val bundle = Bundle()
                bundle.putInt("playlist_id", playlist.id!!)
                context.startActivity(Intent(context, MediaContensActivity::class.java)
                        .putExtras(bundle))
            }
        }

        private fun imageButtonFor(isTrue: Int) : Int{
            return if(isTrue == 1){
                R.drawable.ic_favorite_black_24dp
            } else {
                R.drawable.ic_favorite_border_black_24dp
            }
        }
    }
}