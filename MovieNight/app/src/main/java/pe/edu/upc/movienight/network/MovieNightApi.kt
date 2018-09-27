package pe.edu.upc.movienight.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class MovieNightApi{
    companion object {
        val baseUrl = "https://nodejsmovienight20182.herokuapp.com"
        val getEventsList ="/event/event/"
        fun requestEventList(userId:Int,
                             responseHandler: (EventsResponse?) -> Unit,
                             errorHandler: (ANError?) -> Unit){

            AndroidNetworking.get("$baseUrl$getEventsList$userId")
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsObject(EventsResponse::class.java,object :ParsedRequestListener<EventsResponse>{
                        override fun onResponse(response: EventsResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    })
        }
    }
}