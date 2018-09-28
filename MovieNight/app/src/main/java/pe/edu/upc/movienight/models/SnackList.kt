package pe.edu.upc.movienight.models

import android.os.Bundle

data class SnackList (
        val id: Int? = null,
        val event_id: Int? = null,
        val name: String? = "",
        val original: Boolean? = null,
        val descripcion: String = "" ) {
    companion object {
        fun from(bundle: Bundle): SnackList {
            return SnackList(
                    bundle.getInt("id"),
                    bundle.getInt("event_id"),
                    bundle.getString("name"),
                    bundle.getBoolean("original"),
                    bundle.getString("descripcion")
            )
        }
    }

    fun toBundle(): Bundle{
        val bundle = Bundle()
        bundle.putInt("id",id!!)
        bundle.putInt("event_id",event_id!!)
        bundle.putString("name",name)
        bundle.putBoolean("original",original!!)
        bundle.putString("descripcion",descripcion)
        return bundle
    }
}