package com.okcupid.assessment.extensions

import android.content.Context
import com.okcupid.assessment.R
import com.okcupid.assessment.util.Constants

fun Int.getMatchPercentText(context: Context): String {
    val percent = (this * 100) / Constants.MATCH_MAX
    return context.getString(R.string.match_percent_format, percent)
}