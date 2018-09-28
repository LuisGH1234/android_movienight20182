package pe.edu.upc.movienight.viewControllers.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_snack.view.*
import pe.edu.upc.movienight.R
import pe.edu.upc.movienight.models.Snack
import javax.xml.transform.Source

class SnackAdapter(var snacks: ArrayList<Snack>, val context: Context):
        RecyclerView.Adapter<SnackAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_snack,parent,false))
    }

    override fun getItemCount(): Int {
        return snacks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val snack = snacks[position]
        holder.updateFrom(snack)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val titleTextView = view.titleTextView

        fun updateFrom(snack: Snack) {
        titleTextView.text = snack.name
        }
    }

}