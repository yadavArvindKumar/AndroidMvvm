package edu.arvind.androidmvvm

import android.util.Log
import android.widget.Toast
import com.google.android.play.core.review.ReviewManagerFactory
import edu.arvind.androidmvvm.home.MainActivity

fun askForReview(activity: MainActivity) {
    val manager = ReviewManagerFactory.create(activity)
    val requestFlow = manager.requestReviewFlow()
    requestFlow.addOnCompleteListener { request ->
        if (request.isSuccessful) {
            // We got the ReviewInfo object
            val reviewInfo = request.result
            val flow = manager.launchReviewFlow(activity, reviewInfo)
            flow.addOnCompleteListener { _ ->
                // The flow has finished. The API does not indicate whether the user
                // reviewed or not, or even whether the review dialog was shown. Thus, no
                // matter the result, we continue our app flow.
                Log.d("AppReview", "Review completed.")
                Toast.makeText(activity, "App review Done", Toast.LENGTH_SHORT).show()
            }

        } else {
            // There was some problem, continue regardless of the result.
        }
    }
}