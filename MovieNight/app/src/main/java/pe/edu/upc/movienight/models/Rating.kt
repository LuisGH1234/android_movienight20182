package pe.edu.upc.movienight.models

import android.os.Bundle
import android.os.Parcelable

data class Rating (
        val Source: String? = "",
        val Value: String? = "" ){

    companion object {
        fun from(bundle: Bundle): Rating{
            return Rating(
                    bundle.getString("Source"),
                    bundle.getString("Value")
            )
        }
    }

    fun toBundle(): Bundle{
        val bundle = Bundle()
        bundle.putString("Source", Source)
        bundle.putString("Value", Value)
        return bundle
    }
}