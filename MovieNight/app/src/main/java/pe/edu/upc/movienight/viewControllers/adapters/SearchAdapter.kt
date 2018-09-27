package pe.edu.upc.movienight.viewControllers.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.search_item.view.*
import pe.edu.upc.movienight.R
import pe.edu.upc.movienight.models.Search
import pe.edu.upc.movienight.models.Title
import pe.edu.upc.movienight.viewControllers.activities.TitleActivity

class SearchAdapter(var titles: ArrayList<Search>, val context: Context) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.search_item, parent, false))
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = titles[position]
        holder.updateFrom(title)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //var context = view.context
        var titleDetails = Title()
        val pictureImageView = view.pictureImageView
        val titleImageView = view.titleTextView
        val yearImageView = view.yearTextView
        val searchItemLayout = view.searchItemLayout

        fun updateFrom(title: Search){
            pictureImageView.setDefaultImageResId(R.mipmap.ic_launcher)
            pictureImageView.setErrorImageResId(R.mipmap.ic_launcher)
            pictureImageView.setImageUrl(title.Poster)
            titleImageView.text = title.Title
            yearImageView.text = title.Year
            searchItemLayout.setOnClickListener { view ->
                val context = view.context
                val bundle = Bundle()
                bundle.putString("id", title.imdbID)
                context.startActivity(Intent(context, TitleActivity::class.java)
                        .putExtras(bundle))
                //Log.d("MoviewNight: Adapter", titleDetails.Title)

            }
        }

       /* private fun responseHandler(response: Title?){
            titleDetails = response!!

            Log.d("MoviewNight: Adapter", titleDetails.Poster)
        }

        private fun errorHandler(anError: ANError?){
            Log.d("MoviewNight", anError!!.message)
        }*/
    }


}