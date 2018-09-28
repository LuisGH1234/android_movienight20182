package pe.edu.upc.movienight.viewControllers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.androidnetworking.error.ANError
import kotlinx.android.synthetic.main.fragment_snack.view.*

import pe.edu.upc.movienight.R
import pe.edu.upc.movienight.models.Snack
import pe.edu.upc.movienight.network.MovieNightApi
import pe.edu.upc.movienight.network.OmdbApi
import pe.edu.upc.movienight.network.SnackResponse
import pe.edu.upc.movienight.viewControllers.adapters.SnackAdapter

/**
 * A simple [Fragment] subclass.
 *
 */
class SnackFragment : Fragment() {

    lateinit var snacks: ArrayList<Snack>
    lateinit var snackRecyclerView: RecyclerView
    lateinit var snackAdapter: SnackAdapter
    lateinit var snackLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_snack, container, false)
        snackRecyclerView = view.snackRecyclerView
        snackAdapter = SnackAdapter(snacks,view.context)
        snackLayoutManager = GridLayoutManager(view.context, 2)
        snackRecyclerView.adapter = snackAdapter
        snackRecyclerView.layoutManager = snackLayoutManager


        MovieNightApi.requestSnacks(0,
                {response-> responseHandler(response)},
                { error-> errorHandler(error)})
        return view
    }
    private fun responseHandler(response: SnackResponse?) {
        snacks = response!!.snacks!!
        snackAdapter.snacks = snacks
        snackAdapter.notifyDataSetChanged()

    }
    private fun errorHandler(anError: ANError?) {
        Log.d("MovieNight", anError!!.message)
    }

}
