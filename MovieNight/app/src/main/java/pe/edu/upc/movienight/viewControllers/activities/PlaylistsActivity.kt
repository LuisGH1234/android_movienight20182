package pe.edu.upc.movienight.viewControllers.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.androidnetworking.error.ANError
import pe.edu.upc.movienight.R

import kotlinx.android.synthetic.main.activity_playlists.*
import kotlinx.android.synthetic.main.content_playlists.*
import pe.edu.upc.movienight.models.Playlist
import pe.edu.upc.movienight.network.MovieNightApi
import pe.edu.upc.movienight.network.PlaylistResponse
import pe.edu.upc.movienight.viewControllers.adapters.PlaylistAdapter

class PlaylistsActivity : AppCompatActivity() {

    private var playlists = ArrayList<Playlist>()
    lateinit var playlistRecyclerView: RecyclerView
    lateinit var playlistAdapter: PlaylistAdapter
    lateinit var playlistLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlists)
        setSupportActionBar(toolbar)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Log.d("MOVIENIGHT QVISOOOO", "antes de ineto")
        val intent = intent ?: return
        val eventID = intent.extras!!.getInt("eventID")
        Log.d("MOVIENIGHT QVISOOOO", eventID.toString())

        fab.setOnClickListener { view ->
            val context = view.context
            val bundle = Bundle()
            bundle.putInt("eventID", eventID)
            context.startActivity(Intent(context, AddPlaylistActivity::class.java).putExtras(bundle))
        }

        playlistRecyclerView = playlistRecyclerViewxml
        playlistAdapter = PlaylistAdapter(playlists, baseContext)
        playlistLayoutManager = GridLayoutManager(baseContext, 1)

        playlistRecyclerView.adapter = playlistAdapter
        playlistRecyclerView.layoutManager = playlistLayoutManager

        MovieNightApi.requestPlaylists(eventID,
                { response -> responseHandler(response) },
                { error -> errorHandler(error) })

    }
    private fun responseHandler(response: PlaylistResponse?) {
        val status = response!!.status
        if("error".equals(status, true)){
            Log.d("MovieNight", "PlaylistFragment responseHandler fails request")
            return
        }
        playlists = response.playlists!!
        playlistAdapter.playlists = playlists
        playlistAdapter.notifyDataSetChanged()
    }

    private fun errorHandler(anError: ANError?){
        Log.d("MovieNight", anError!!.message)
    }
}
