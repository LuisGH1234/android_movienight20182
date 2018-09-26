package pe.edu.upc.movienight.viewControllers.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import pe.edu.upc.movienight.R
import pe.edu.upc.movienight.viewControllers.fragments.EventsFragment
import pe.edu.upc.movienight.viewControllers.fragments.LibraryFragment
import pe.edu.upc.movienight.viewControllers.fragments.SearchFragment
import pe.edu.upc.movienight.viewControllers.fragments.UserFragment

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        navigation.selectedItemId = R.id.navigation_search
    }

    private fun fragmentFor(item: MenuItem): Fragment{
        when (item.itemId) {
            R.id.navigation_user -> {
                return UserFragment()
            }
            R.id.navigation_event -> {
                return EventsFragment()
            }
            R.id.navigation_search -> {
                return SearchFragment()
            }
            R.id.navigation_library -> {
                return LibraryFragment()
            }
        }
        return LibraryFragment()
    }

    private fun navigateTo(item: MenuItem): Boolean{
        item.isChecked = true
        return supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout_activitymain, fragmentFor(item))
                .commit() > 0
    }
}
