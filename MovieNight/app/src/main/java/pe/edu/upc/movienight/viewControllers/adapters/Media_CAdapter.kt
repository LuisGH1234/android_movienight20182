package pe.edu.upc.movienight.viewControllers.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.media_content_item.view.*
import pe.edu.upc.movienight.R
import pe.edu.upc.movienight.models.Media_Content
import pe.edu.upc.movienight.viewControllers.activities.TitleActivity

class Media_CAdapter (var media_contents: ArrayList<Media_Content>, val context: Context) :
        RecyclerView.Adapter<Media_CAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.media_content_item, parent, false))
    }

    override fun getItemCount(): Int {
        return media_contents.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mediaContent = media_contents[position]
        holder.updateFrom(mediaContent)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val mediacontentLayout = view.mediacontentLayout
        val pictureImageView = view.pictureImageView
        val titleTextView = view.titleTextView
        val yearTextView = view.yearTextView

        fun updateFrom (mediaContent: Media_Content){
            pictureImageView.setDefaultImageResId(R.mipmap.ic_launcher)
            pictureImageView.setErrorImageResId(R.mipmap.ic_launcher)
            pictureImageView.setImageUrl(mediaContent.image_url)
            titleTextView.text = mediaContent.title
            yearTextView.text = mediaContent.year
            mediacontentLayout.setOnClickListener { view ->
                val context = view.context
                val bundle = Bundle()
                bundle.putString("title", mediaContent.title)
                bundle.putString("year", mediaContent.year)
                context.startActivity(Intent(context, TitleActivity::class.java)
                        .putExtras(bundle))
            }
        }
    }
}