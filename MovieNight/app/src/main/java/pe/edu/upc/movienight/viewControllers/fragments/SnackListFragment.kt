package pe.edu.upc.movienight.viewControllers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnetworking.error.ANError
import kotlinx.android.synthetic.main.fragment_snack_list.view.*
import pe.edu.upc.movienight.MovieNightApp

import pe.edu.upc.movienight.R
import pe.edu.upc.movienight.models.SnackList
import pe.edu.upc.movienight.network.MovieNightApi
import pe.edu.upc.movienight.network.SnackListResponse
import pe.edu.upc.movienight.viewControllers.adapters.SnackListAdapter


/**
 * A simple [Fragment] subclass.
 *
 */
class SnackListFragment : Fragment() {

    lateinit var snackList: ArrayList<SnackList>
    lateinit var snackListRecyclerView: RecyclerView
    lateinit var snackListAdapter: SnackListAdapter
    lateinit var snackListLayoutManager: RecyclerView.LayoutManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_snack_list, container, false)

        snackListRecyclerView = view.snackListRecyclerView
        snackListAdapter = SnackListAdapter(snackList,view.context)
        snackListLayoutManager = GridLayoutManager(view.context,2)
        snackListRecyclerView.adapter = snackListAdapter
        snackListRecyclerView.layoutManager = snackListLayoutManager

        MovieNightApi.requestSnackLists(0,
                {response->responseHandler(response)},
                {error->errorHandler(error)})

        return view
    }

    private fun responseHandler(response: SnackListResponse?){
        snackList = response!!.snacklists!!
        snackListAdapter.snacklists = snackList
        snackListAdapter.notifyDataSetChanged()
    }
    private fun errorHandler(anError: ANError?) {
        Log.d("MovieNight", anError!!.message)
    }


}
