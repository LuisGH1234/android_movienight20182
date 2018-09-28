package pe.edu.upc.movienight.models

import android.os.Bundle

data class Playlist (
        val id: Int? = null,
        val event_id: Int? = null,
        val name: String? = "",
        val original: Int? = null,
        val description: String? = ""){

    companion object {
        fun from (bundle: Bundle) : Playlist{
            return Playlist(
                    bundle.getInt("id"),
                    bundle.getInt("event_id"),
                    bundle.getString("name"),
                    bundle.getInt("original"),
                    bundle.getString("description")
            )
        }
    }

    fun toBundle() : Bundle {
        val bundle = Bundle()
        bundle.putInt("id", id!!)
        bundle.putInt("event_id", event_id!!)
        bundle.putString("name", name)
        bundle.putInt("original", original!!)
        bundle.putString("description", description)
        return bundle
    }
}