package pe.edu.upc.movienight.models

import android.os.Bundle

data class Media_Content (
        val id: Int? = 0,
        val playlist_id: Int? = 0,
        val title: String? = "",
        val year: String? = "",
        val image_url: String? = ""
){
    companion object {
        fun from(bundle: Bundle) : Media_Content{
            return Media_Content(
                    bundle.getInt("id"),
                    bundle.getInt("playlist_id"),
                    bundle.getString("title"),
                    bundle.getString("year"),
                    bundle.getString("image_url")
            )
        }
    }

    fun toBundle() : Bundle {
        val bundle = Bundle()
        bundle.putInt("id", id!!)
        bundle.putInt("playlist_id", playlist_id!!)
        bundle.putString("title", title)
        bundle.putString("year", year)
        bundle.putString("image_url", image_url)
        return bundle
    }
}