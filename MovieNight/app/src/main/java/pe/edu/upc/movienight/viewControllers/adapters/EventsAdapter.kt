package pe.edu.upc.movienight.viewControllers.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.upc.movienight.R
import kotlinx.android.synthetic.main.event_item.view.*
import pe.edu.upc.movienight.models.Event
import pe.edu.upc.movienight.viewControllers.activities.EventActivity

class EventsAdapter(var events:ArrayList<Event>, val context: Context):RecyclerView.Adapter<EventsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.event_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = events.get(position)
        holder.updateFrom(event)
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val eventLayout=view.eventLayout
        val nameTextView=view.nameTextView
        val dateTextView=view.dateTextView
        val locationTextView=view.locationTextView

        fun updateFrom(event:Event){
            nameTextView.text = event.name
            dateTextView.text = event.date
            locationTextView.text = event.location
            eventLayout.setOnClickListener { view ->
                val context = view.context
                context.startActivity(
                        Intent(context,EventActivity::class.java)
                                .putExtras(event.toBundle())
                )
            }
        }
    }

}

