package pe.edu.upc.movienight.viewControllers.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import pe.edu.upc.movienight.R

import kotlinx.android.synthetic.main.activity_title.*
import kotlinx.android.synthetic.main.content_title.*
import pe.edu.upc.movienight.models.Title
import pe.edu.upc.movienight.network.OmdbApi

class TitleActivity : AppCompatActivity() {

    var title = Title()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val intent = intent ?: return
        //val title = Title.from(intent.extras!!)
        val id = intent.extras!!.getString("id")
        Log.d("CODIGO DE PELICULA", id)
        OmdbApi.requestTitleByImdbID(getString(R.string.omdb_api_key), id!!,
                { response -> responseHandler(response) },
                { error -> errorHandler(error) })


    }

    private fun responseHandler(response: Title?){
        Log.d("Response", response!!.Poster)
        title = response

        pictureImageView.setErrorImageResId(R.mipmap.ic_launcher)
        pictureImageView.setDefaultImageResId(R.mipmap.ic_launcher)
        pictureImageView.setImageUrl(title.Poster)
        titleImageView.text = title.Title
        yearImageView.text = title.Year
        plotImageView.text = title.Plot
    }

    private fun errorHandler(anError: ANError?){
        Log.d("MoviewNight", anError!!.message)
    }

}
