package pe.edu.upc.movienight.network

import android.content.Context
import android.preference.PreferenceManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import android.support.v7.app.AppCompatActivity
import org.json.JSONObject

class MovieNightApi{
    companion object {

        private val ACCOUNT_TOKEN = "userToken"
        private val STRING_PREFERENCE = "Session"

        val baseUrl = "http://movienight21012.herokuapp.com/api/v2"


        val EventActions ="$baseUrl/users/:user_id/events"
        val getPlaylists = "$baseUrl/events/:event_id/playlists"
        /* No aparece en la documentacion
        val getEventsList ="/event/event/"
        */
        val getSnacks = "$baseUrl/events/:event_id/snacklists/:snacklist_id/snacks"
        val getMediaContents = "$baseUrl/events/:event_id/playlists/:playlist_id/media_contents"
        val getsnacklist ="$baseUrl/events/:event_id/snacklists"
        val postPlaylist = "$baseUrl/events/:event_id/playlists"

        fun requestEventList(userId:Int,
                             responseHandler: (EventsResponse?) -> Unit,
                             errorHandler: (ANError?) -> Unit){

            AndroidNetworking.get("http://movienight21012.herokuapp.com/api/v2/users/1/events")
                    .addHeaders("authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZGQiOjEsInN1YiI6ImxhZ2gzLjMwQGdtYWlsLmNvbSIsInB3ZCI6ImFiYzEyM2FiYyIsInBobyI6Ijk5OTg4ODc3NyJ9.g3WgTpMcZV4NeR7ullAriF3XSLRTcFAEnmmYgFHMDaU")
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
                    .getAsObject(NewEventResponse::class.java,object :ParsedRequestListener<NewEventResponse> {
                        override fun onResponse(response: NewEventResponse?) {
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

        fun requestPlaylists(eventID: Int,
                             responseHandler: (PlaylistResponse?) -> Unit,
                             errorHandler: (ANError?) -> Unit){

            AndroidNetworking.get("$getPlaylists$eventID").setPriority(Priority.LOW).build()
                    .getAsObject(PlaylistResponse::class.java, object : ParsedRequestListener<PlaylistResponse>{
                        override fun onResponse(response: PlaylistResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }
                    })
        }

        fun postNewPlaylist(eventID: Int, nameP: String, descriptionP: String,
                            responseHandler: (NewEventResponse?) -> Unit,
                            errorHandler: (ANError?) -> Unit){

            val json: JSONObject = JSONObject()
            json.put("name", nameP)
            json.put("description", descriptionP)
            json.put("event_id", eventID)
            json.put("original", 0)

            AndroidNetworking.post(postPlaylist).addHeaders("Content-Type", "application/json")
                    .addJSONObjectBody(json).setPriority(Priority.LOW).build()
                    .getAsObject(NewEventResponse::class.java, object : ParsedRequestListener<NewEventResponse>{
                        override fun onResponse(response: NewEventResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }
                    })
        }

        fun requestMediaContents(playlistID: Int,
                                 responseHandler: (Media_CResponse?) -> Unit,
                                 errorHandler: (ANError?) -> Unit){

            AndroidNetworking.get("$baseUrl$getMediaContents$playlistID")
                    .setPriority(Priority.LOW).build()
                    .getAsObject(Media_CResponse::class.java, object : ParsedRequestListener<Media_CResponse>{
                        override fun onResponse(response: Media_CResponse?) {
                            responseHandler(response)
                        }

                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }
                    })
        }
    }
}