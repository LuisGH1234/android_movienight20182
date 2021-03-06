package pe.edu.upc.movienight.viewControllers.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_onboarding.*
import kotlinx.android.synthetic.main.content_onboarding.*
import pe.edu.upc.movienight.R

class onboardingActivity : AppCompatActivity() {

    private val STRING_PREFERENCE = "Session"
    private val ACCOUNT_TOKEN = "userToken"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)


        val preferences = getSharedPreferences(STRING_PREFERENCE, Context.MODE_PRIVATE)
        val token = preferences.getString(ACCOUNT_TOKEN, null)

        if ( token != null) {
            launchHomeActivity()
        }
    }

    private fun launchHomeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun onLogin(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_onboarding, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
