package pe.edu.upc.movienight.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import org.json.JSONObject

class MovieNightApi{
    companion object {
        val baseUrl = "https://nodejsmovienight20182.herokuapp.com"
<<<<<<< HEAD
        val EventActions ="/event/event/"
=======
        val getEventsList ="/event/event/"
        val getSnacks = "/event/snack/"
        val getsnacklist ="/event/snacklist/"
>>>>>>> ef16c12e8f82d36596593a25802e285f4d5b9499
        fun requestEventList(userId:Int,
                             responseHandler: (EventsResponse?) -> Unit,
                             errorHandler: (ANError?) -> Unit){

            AndroidNetworking.get("$baseUrl$EventActions$userId")
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

<<<<<<< HEAD
        fun postNewEvent(userId:Int,name:String,location:String,date:String,
                         responseHandler: (NewEventResponse?) -> Unit,
                         errorHandler: (ANError?) -> Unit){

            val json:JSONObject = JSONObject()
            json.put("name",name)
            json.put("location",location)
            json.put("date",date)
            json.put("user_id",userId)
            json.put("rol_id",11) //Organizador

            AndroidNetworking.post("$baseUrl$EventActions")
                    .addHeaders("Content-Type","application/json")
                    .addJSONObjectBody(json)
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsObject(NewEventResponse::class.java,object :ParsedRequestListener<NewEventResponse>{
                        override fun onResponse(response: NewEventResponse?) {
                            responseHandler(response)
                        }
=======
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

>>>>>>> ef16c12e8f82d36596593a25802e285f4d5b9499
                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    })
        }
    }
}