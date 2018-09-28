package pe.edu.upc.movienight.viewControllers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import kotlinx.android.synthetic.main.fragment_snack.view.*

import pe.edu.upc.movienight.R
import pe.edu.upc.movienight.models.Snack
import pe.edu.upc.movienight.network.OmdbApi
import pe.edu.upc.movienight.viewControllers.adapters.SnackAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SnackFragment : Fragment() {

    private lateinit var snacks: ArrayList<Snack>
    private lateinit var snackRecyclerView: RecyclerView
    private lateinit var snackAdapter: SnackAdapter
    private lateinit var snackLayoutManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_snack, container, false)
        snackRecyclerView = view.snackRecyclerView
        snackAdapter = SnackAdapter(snacks,view.context)
        snackLayoutManager = GridLayoutManager(view.context, 2)
        snackRecyclerView.adapter = snackAdapter
        snackRecyclerView.layoutManager = snackLayoutManager

        return view
    }


}
