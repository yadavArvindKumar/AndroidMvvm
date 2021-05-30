package edu.arvind.androidmvvm.home

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { onReviewMeClicked() })
                { Text("Review Me!!") }
            }
        }
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
