package pe.edu.upc.movienight.network

import pe.edu.upc.movienight.models.Snack

class SnackResponse {
    val status: String = ""
    val id: Int? = 0
    val snacklist_id: Int? = 0
    val name: String? = ""
    val trademark: String? = ""
    var snacks: ArrayList<Snack>? = null
}