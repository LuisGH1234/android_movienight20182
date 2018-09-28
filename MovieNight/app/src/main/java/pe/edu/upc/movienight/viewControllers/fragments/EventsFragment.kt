package pe.edu.upc.movienight.viewControllers.fragments




import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnetworking.error.ANError
import kotlinx.android.synthetic.main.fragment_events.view.*
import pe.edu.upc.movienight.R
import pe.edu.upc.movienight.models.Event
import pe.edu.upc.movienight.network.EventsResponse
import pe.edu.upc.movienight.network.MovieNightApi
import pe.edu.upc.movienight.viewControllers.adapters.EventsAdapter

/**
 * A simple [Fragment] subclass.
 *
 */
class EventsFragment : Fragment() {
    var events = ArrayList<Event>()
    lateinit var eventsRecyclerView:RecyclerView
    lateinit var eventsAdapter:EventsAdapter
    lateinit var eventsLayoutManager:RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_events, container, false)
        eventsRecyclerView=view.eventsRecyclerView
        eventsAdapter=EventsAdapter(events,view.context)
        eventsLayoutManager= GridLayoutManager(view.context,1) as RecyclerView.LayoutManager
        eventsRecyclerView.adapter=eventsAdapter
        eventsRecyclerView.layoutManager=eventsLayoutManager

        MovieNightApi.requestEventList(61,
                {response->responseHandler(response)},
                { error -> errorHandler(error)})
        return view
    }
    private fun responseHandler(response: EventsResponse?){
        if (!response!!.status.equals("ok")){
            return
        }
        Log.d("MovieNight","Found ${response.events!!.size}")
        events = response.events!!
        eventsAdapter.events = events
        eventsAdapter.notifyDataSetChanged()
    }

    private fun errorHandler(anError: ANError?){
        Log.d("MovieNight", anError!!.message)
    }

}
