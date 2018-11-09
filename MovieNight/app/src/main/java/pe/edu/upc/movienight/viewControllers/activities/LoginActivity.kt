package pe.edu.upc.movienight.viewControllers.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import pe.edu.upc.movienight.R

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val STRING_PREFERENCE = "Session"
    private val ACCOUNT_TOKEN = "userToken"

    var email = null
    var password = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onLogin(view: View) {


        launchHomeActivity()

    }

    private fun launchHomeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}
