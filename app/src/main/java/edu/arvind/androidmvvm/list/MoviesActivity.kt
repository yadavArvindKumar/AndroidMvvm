package edu.arvind.androidmvvm.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieListContent()
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, MoviesActivity::class.java)
    }
}