package pe.edu.upc.movienight.viewControllers.activities

import android.content.Context
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

        val preferences = getSharedPreferences(STRING_PREFERENCE, Context.MODE_PRIVATE)
        preferences.edit().putString(ACCOUNT_TOKEN, "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZGQiOjEsInN1YiI6ImxhZ2gzLjMwQGdtYWlsLmNvbSIsInB3ZCI6ImFiYzEyM2FiYyIsInBobyI6Ijk5OTg4ODc3NyJ9.g3WgTpMcZV4NeR7ullAriF3XSLRTcFAEnmmYgFHMDaU").apply()
        launchHomeActivity()

    }

    private fun launchHomeActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}
