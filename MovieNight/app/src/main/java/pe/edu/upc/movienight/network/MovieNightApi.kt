package pe.edu.upc.movienight.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class MovieNightApi{
    companion object {
        val baseUrl = "https://nodejsmovienight20182.herokuapp.com"
        val getEventsList ="/event/event/"
        val getSnacks = "/event/snack/"
        val getsnacklist ="/event/snacklist/"
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

        fun requestSnacks(snackListId:Int,
                         responseHandler: (SnackResponse?) -> Unit,
                         errorHandler: (ANError?) -> Unit){

            AndroidNetworking.get("$baseUrl$getSnacks$snackListId")
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsObject(SnackResponse::class.java,object :ParsedRequestListener<SnackResponse>{
                        override fun onResponse(response: SnackResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    })
        }

        fun requestSnackLists(eventId:Int,
                          responseHandler: (SnackListResponse?) -> Unit,
                          errorHandler: (ANError?) -> Unit){

            AndroidNetworking.get("$baseUrl$getSnacks$eventId")
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsObject(SnackListResponse::class.java,object :ParsedRequestListener<SnackListResponse>{
                        override fun onResponse(response: SnackListResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    })
        }
    }
}