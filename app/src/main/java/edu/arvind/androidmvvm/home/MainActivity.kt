package edu.arvind.androidmvvm.home

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.arvind.androidmvvm.AppTheme
import edu.arvind.androidmvvm.askForReview

class MainActivity : ComponentActivity() {
    private val viewModel by lazy { getMainViewModel(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityContent()
        }
        initObservers()
    }

    private fun initObservers() {
        viewModel.navigator.reviewButtonTrigger.observe(this, ::handleReviewButtonTrigger)
    }

    private fun handleReviewButtonTrigger(unit: Unit?) {
        Log.d("MainActivity", "handleReviewButtonTrigger")
        askForReview(this)
    }

    @Composable
    fun ActivityContent() {
        AppTheme {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Button(onClick = { onReviewMeClicked() })
                    { Text("Review Me!!") }
                }
                item {
                    Button(onClick = { onShowMoviesClicked() })
                    { Text("Show List of Movies!") }
                }
            }
        }
    }

    private fun onShowMoviesClicked() {

    }

    private fun onReviewMeClicked() {
        viewModel.onReviewMeClicked()
    }

    @Composable
    @Preview
    fun PreviewActivity() {
        ActivityContent()
    }
}
