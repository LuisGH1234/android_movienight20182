package pe.edu.upc.movienight.models

import android.os.Bundle

data class Title (
        val Title: String? = "",
        val Year: String? = "",
        val Rated: String? = "",
        val Released: String? = "",
        val Runtime: String? = "",
        val Genre: String? = "",
        val Director: String? = "",
        val Writer: String? = "",
        val Actors: String? = "",
        val Plot: String? = "",
        val Language: String? = "",
        val Country: String? = "",
        val Awards: String? = "",
        val Poster: String? = "",
        //val Ratings: ArrayList<Rating>? = null,
        val Metascore: String? = "",
        val imdbRating: String? = "",
        val imdbVotes: String? = "",
        val imdbID: String? = "",
        val Type: String? = "",
        val DVD: String? = "",
        val BoxOffice: String? = "",
        val Production: String? = "",
        val Website: String? = "",
        val Response: String? = "" ){

    companion object {
        fun from(bundle: Bundle): Title{
            return Title(
                    bundle.getString("Title"),
                    bundle.getString("Year"),
                    bundle.getString("Rated"),
                    bundle.getString("Released"),
                    bundle.getString("Runtime"),
                    bundle.getString("Director"),
                    bundle.getString("Writer"),
                    bundle.getString("Actors"),
                    bundle.getString("Plot"),
                    bundle.getString("Language"),
                    bundle.getString("Awards"),
                    bundle.getString("Poster"),
                    bundle.getString("Country"),
                    bundle.getString("Metascore"),
                    //Rating.from(bundle.getBundle("Ratings")),
                    bundle.getString("imdbVotes"),
                    bundle.getString("imdbID"),
                    bundle.getString("Type"),
                    bundle.getString("DVD"),
                    bundle.getString("BoxOffice"),
                    bundle.getString("Production"),
                    bundle.getString("Website"),
                    bundle.getString("Response")
            )
        }
    }

    fun toBundle(): Bundle{
        val bundle = Bundle()
        bundle.putString("Title",Title)
        bundle.putString("Year",Year)
        bundle.putString("Rated",Rated)
        bundle.putString("Released",Released)
        bundle.putString("Runtime",Runtime)
        bundle.putString("Director",Director)
        bundle.putString("Writer",Writer)
        bundle.putString("Actors",Actors)
        bundle.putString("Plot",Plot)
        bundle.putString("Language",Language)
        bundle.putString("Awards",Awards)
        bundle.putString("Poster",Poster)
        bundle.putString("Country",Country)
        bundle.putString("Metascore",Metascore)
        //bundle.putStringArrayList("Ratings", Ratings)
        bundle.putString("imdbVotes",imdbVotes)
        bundle.putString("imdbID",imdbID)
        bundle.putString("Type",Type)
        bundle.putString("DVD",DVD)
        bundle.putString("BoxOffice",BoxOffice)
        bundle.putString("Production",Production)
        bundle.putString("Website",Website)
        bundle.putString("Response",Response)
        return bundle
    }
}