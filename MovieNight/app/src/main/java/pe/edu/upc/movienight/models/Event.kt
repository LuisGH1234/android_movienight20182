package pe.edu.upc.movienight.models

import android.os.Bundle

data class Event(
        val id:Int,
        val name:String?,
        val location:String?,
        val date:String?
){
    companion object {
        fun from(bundle: Bundle): Event{
            return Event(
                    bundle.getInt("id"),
                    bundle.getString("name"),
                    bundle.getString("location"),
                    bundle.getString("date")
            )
        }
    }

    fun toBundle(): Bundle {
        val bundle = Bundle()
        bundle.putInt("id", id)
        bundle.putString("name", name)
        bundle.putString("location", location)
        bundle.putString("date", date)
        return bundle
    }
}