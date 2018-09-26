package pe.edu.upc.movienight

import android.app.Application
import com.androidnetworking.AndroidNetworking

class MovieNightApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)
    }
}