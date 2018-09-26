package pe.edu.upc.movienight.network

import java.net.URL

class LogoApi {
    companion object {
        val baseUrl = "https://http://logo.clearbit.com/"
        fun urlToImage(url: String): String{
            val host = URL(url).host
            return "$baseUrl$host"
        }
    }
}