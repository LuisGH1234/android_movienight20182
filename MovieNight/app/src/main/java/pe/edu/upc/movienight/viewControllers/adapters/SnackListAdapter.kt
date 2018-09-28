package pe.edu.upc.movienight.viewControllers.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_snacklist.view.*
import pe.edu.upc.movienight.R
import pe.edu.upc.movienight.models.SnackList

class SnackListAdapter(var snacklists: ArrayList<SnackList>, val context: Context) :
        RecyclerView.Adapter<SnackListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_snacklist,parent,false))
    }

    override fun getItemCount(): Int {
        return snacklists.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val snacklist = snacklists.get(position)
        holder.updateFrom(snacklist)
    }


    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val titleTextView = view.titleTextView

        fun updateFrom(snacklist: SnackList) {
            titleTextView.text = snacklist.name
        }
    }
}