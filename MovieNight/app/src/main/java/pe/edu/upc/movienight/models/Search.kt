package pe.edu.upc.movienight.models

import android.os.Bundle

data class Search (
        val Title: String? = "",
        val Year: String? = "",
        val imdbID: String? = "",
        val Type: String? = "",
        val Poster: String? = "" ){

    companion object {
        fun from(bundle: Bundle): Search{
            return Search(
                    bundle.getString("Title"),
                    bundle.getString("Year"),
                    bundle.getString("imdbID"),
                    bundle.getString("Type"),
                    bundle.getString("Poster")
            )
        }
    }

    fun toBundle(): Bundle{
        val bundle = Bundle()
        bundle.putString("Title", Title)
        bundle.putString("Year", Year)
        bundle.putString("imdbID", imdbID)
        bundle.putString("Type", Type)
        bundle.putString("Poster", Poster)
        return bundle
    }
}