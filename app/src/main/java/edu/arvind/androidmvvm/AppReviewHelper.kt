package edu.arvind.androidmvvm

import com.google.android.play.core.review.ReviewManagerFactory

fun askForReview(activity: MainActivity) {
    val reviewManager = ReviewManagerFactory.create(activity.applicationContext)
    val requestFlow = reviewManager.requestReviewFlow()
    requestFlow.addOnCompleteListener { request ->
        if (request.isSuccessful) {
            val reviewInfo = request.result
            val flow = reviewInfo.let {
                reviewManager.launchReviewFlow(activity, it)
            }
            flow.addOnCompleteListener { _ ->
                // do nothing
            }
        } else {
            null
        }
    }
}