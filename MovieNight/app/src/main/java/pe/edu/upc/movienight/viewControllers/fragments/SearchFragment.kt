package pe.edu.upc.movienight.viewControllers.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.androidnetworking.error.ANError
import kotlinx.android.synthetic.main.fragment_search.view.*

import pe.edu.upc.movienight.R
import pe.edu.upc.movienight.models.Search
import pe.edu.upc.movienight.network.OmdbApi
import pe.edu.upc.movienight.network.SearchResponse
import pe.edu.upc.movienight.viewControllers.adapters.SearchAdapter

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchFragment : Fragment() {

    private lateinit var titles: ArrayList<Search>
    private lateinit var searchRecyclerView: RecyclerView
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var searchLayoutManager: RecyclerView.LayoutManager
    private lateinit var searchEditText: EditText
    private lateinit var searchButton: ImageButton
    private lateinit var inm: InputMethodManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        titles = ArrayList()
        searchEditText = view.searchEditText
        searchButton = view.searchButton
        searchRecyclerView = view.searchRecyclerView
        searchAdapter = SearchAdapter(titles, view.context)
        searchLayoutManager = GridLayoutManager(view.context, 2)

        searchRecyclerView.adapter = searchAdapter
        searchRecyclerView.layoutManager = searchLayoutManager

        inm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


        searchButton.setOnClickListener {
            if(!searchEditText.text.toString().isEmpty()){
                val text = searchEditText.text.toString()
                OmdbApi.requestSearch(getString(R.string.omdb_api_key), text,
                        { response -> responseHandler(response) },
                        { error -> errorHandler(error) })
            }
            searchEditText.clearFocus()
            //esconder el keyboard
            inm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        return view
    }

    private fun responseHandler(response: SearchResponse?){
        /*if(response!!.Search!!.size <= 0){
            Log.d("MovieNight", "No se encontraron coincidencias")
            return
        }*/
        titles = response!!.Search!!
        searchAdapter.titles = titles
        searchAdapter.notifyDataSetChanged()
    }

    private fun errorHandler(anError: ANError?){
        Log.d("MovieNight", anError!!.message)
    }
}
