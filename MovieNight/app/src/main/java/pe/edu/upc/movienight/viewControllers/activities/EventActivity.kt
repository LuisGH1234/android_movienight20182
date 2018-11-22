package pe.edu.upc.movienight.viewControllers.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import pe.edu.upc.movienight.R

import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.content_event.*
import pe.edu.upc.movienight.models.Event

class EventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_event)
            setSupportActionBar(toolbar)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            val intent=intent?:return
            val event = Event.from(intent.extras!!)
            nameTextView.text=event.name_event
            dateTextView.text = event.date
            locationTextView.text= event.location

            viewPlayList.setOnClickListener {view->
                val context= view.context
                    val bundle = Bundle()
                    bundle.putInt("eventID", event.id)
                context.startActivity(Intent(view.context,PlaylistsActivity::class.java).putExtras(bundle))
            }

            /*viewSnackList.setOnClickListener { view->
                val context= view.context
                context.startActivity(Intent(view.context,ViewSnackListActivity::class.java).putExtras(event.toBundle()))
            }*/


    }



}
