package pe.edu.upc.movienight.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import pe.edu.upc.movienight.models.Title

class OmdbApi {
    companion object {
        val baseUrl = "http://www.omdbapi.com/"

        fun requestSearch(key: String, word: String,
                          responseHandler: (SearchResponse?) -> Unit,
                          errorHandler: (ANError?) -> Unit){
            AndroidNetworking.get(baseUrl).addQueryParameter("apikey", key)
                    .addQueryParameter("s", word).setPriority(Priority.LOW)
                    /*.setTag("MovieNight")*/.build()
                    .getAsObject(SearchResponse::class.java, object : ParsedRequestListener<SearchResponse>{
                        override fun onResponse(response: SearchResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }
                    })
        }

        fun requestTitleByImdbID(key: String, imdbID: String,
                                 responseHandler: (Title?) -> Unit,
                                 errorHandler: (ANError?) -> Unit){
            AndroidNetworking.get(baseUrl).addQueryParameter("apikey", key)
                    .addQueryParameter("i", imdbID).setPriority(Priority.LOW)
                    /*.setTag("MovieNight")*/.build()
                    .getAsObject(Title::class.java, object : ParsedRequestListener<Title>{
                        override fun onResponse(response: Title?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }
                    })
        }
    }
}