package pe.edu.upc.movienight.viewControllers.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import com.androidnetworking.error.ANError
import pe.edu.upc.movienight.R

import kotlinx.android.synthetic.main.activity_add_playlist.*
import kotlinx.android.synthetic.main.content_add_playlist.*
import pe.edu.upc.movienight.network.MovieNightApi
import pe.edu.upc.movienight.network.NewEventResponse

class AddPlaylistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_playlist)
        setSupportActionBar(toolbar)

        val intent = intent ?: return
        val eventID = intent.extras!!.getInt("eventID")
        val nameP = editName.text.toString()
        val descriptionP = editDescription.text.toString()

        addPlaylistButton.setOnClickListener { _ ->
            MovieNightApi.postNewPlaylist(eventID, editName.text.toString(), editDescription.text.toString(),
                    { response -> responseHandler(response) },
                    { error -> errorHandler(error) })
        }
    }

    private fun responseHandler(response: NewEventResponse?){
        if("done".equals(response!!.status, true)){
            Log.d("MovieNight", "Insert Playlist done")
            this.finish()
        } else {
            Log.d("MovieNight", "Insert Playlist error")
        }
    }

    private fun errorHandler(anError: ANError?){
        Log.d("MovieNight", anError!!.message)
    }

}
