package pe.edu.upc.movienight.viewControllers.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.androidnetworking.error.ANError
import pe.edu.upc.movienight.R

import kotlinx.android.synthetic.main.activity_media_contens.*
import kotlinx.android.synthetic.main.content_media_contens.*
import pe.edu.upc.movienight.models.Media_Content
import pe.edu.upc.movienight.network.Media_CResponse
import pe.edu.upc.movienight.network.MovieNightApi
import pe.edu.upc.movienight.viewControllers.adapters.Media_CAdapter

class MediaContensActivity : AppCompatActivity() {

    var mediaContents = ArrayList<Media_Content>()
    lateinit var mediaContentRecyclerView: RecyclerView
    lateinit var mediaContentAdapter: Media_CAdapter
    lateinit var mediaContentLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_contens)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent ?: return
        val playlistID = intent.extras!!.getInt("playlist_id")

        mediaContentRecyclerView = mediaContentRecyclerViewxml
        mediaContentAdapter = Media_CAdapter(mediaContents, baseContext)
        mediaContentLayoutManager = GridLayoutManager(baseContext, 2)

        mediaContentRecyclerView.adapter = mediaContentAdapter
        mediaContentRecyclerView.layoutManager = mediaContentLayoutManager

        //Falta el ID de la playlist
        MovieNightApi.requestMediaContents(playlistID,
                { response -> responseHandler(response) },
                { error -> errorHandler(error) })
    }
    private fun responseHandler(response: Media_CResponse?){
        val status = response!!.status
        if("error".equals(status, true)){
            Log.d("MovieNight", "Media Content Fragment responseHandler status error")
            return
        }
        mediaContents = response!!.media_contents!!
        mediaContentAdapter.media_contents = mediaContents
        mediaContentAdapter.notifyDataSetChanged()
    }

    private fun errorHandler(anError: ANError?){
        Log.d("MovieNight", anError!!.message)
    }
}
