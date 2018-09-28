package pe.edu.upc.movienight.models


import android.os.Bundle

data class Snack (
        val id: Int? = 0,
        val snacklist_id: Int? = 0,
        val name: String? = "",
        val trademark: String? = ""){

    companion object {
        fun from(bundle: Bundle): Snack {
            return Snack (
                    bundle.getInt("id"),
                    bundle.getInt("snacklist_id"),
                    bundle.getString("name"),
                    bundle.getString("trademark")
            )
        }
    }
    fun toBundle(): Bundle{
        val bundle = Bundle()
        bundle.putInt("id",id!!)
        bundle.putInt("snacklist_id",snacklist_id!!)
        bundle.putString("name",name)
        bundle.putString("trademark",trademark)
        return bundle
    }

}