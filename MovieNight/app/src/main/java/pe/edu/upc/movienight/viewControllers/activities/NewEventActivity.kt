package pe.edu.upc.movienight.viewControllers.activities

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import com.androidnetworking.error.ANError
import pe.edu.upc.movienight.R

import kotlinx.android.synthetic.main.activity_new_event.*
import kotlinx.android.synthetic.main.content_new_event.view.*
import pe.edu.upc.movienight.network.MovieNightApi
import pe.edu.upc.movienight.network.NewEventResponse

class NewEventActivity : AppCompatActivity() {
    var nameEditText: EditText? = null
    var locationEditText: EditText? = null
    var dateEditText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_event)
        setSupportActionBar(toolbar)
        nameEditText=findViewById(R.id.nameEditText) as EditText
        locationEditText=findViewById(R.id.locationEditText) as EditText
        dateEditText=findViewById(R.id.dateEditText) as EditText
        checkFAB.setOnClickListener {view->
            if(!nameEditText!!.text.toString().equals("") and
                    !locationEditText!!.text.toString().equals("") and
                    !locationEditText!!.text.toString().equals("")) {
                MovieNightApi.postNewEvent(61,
                        nameEditText!!.text.toString(),
                        locationEditText!!.text.toString(),
                        dateEditText!!.text.toString(),
                        { response -> responseHandler(response,view) },
                        { error -> errorHandler(error) })
            }

        }


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    private fun responseHandler(response: NewEventResponse?,view:View){
        if (!response!!.status.equals("done")){
            return
        }
        Log.d("MovieNight","Event Created")
        startActivity(Intent(view.context,MainActivity::class.java))
    }

    private fun errorHandler(anError: ANError?){
        Log.d("MovieNight", anError!!.message)
    }

    /** Check if this device has a camera */
    private fun checkCameraHardware(context: Context): Boolean {
        if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true
        }

        return false

    }

}
