package pe.edu.upc.movienight.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import org.json.JSONObject

class MovieNightApi{
    companion object {
        val baseUrl = "https://nodejsmovienight20182.herokuapp.com"
        val EventActions ="/event/event/"
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
                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    })
        }
    }
}