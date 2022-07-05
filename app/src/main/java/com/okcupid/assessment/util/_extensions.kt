package com.okcupid.assessment.util

import android.content.Context
import com.okcupid.assessment.R
import com.okcupid.assessment.entities.PetItem

/**
 * @return Cloned instance [List] of [PetItem]
 */
fun List<PetItem>.cloneList(): ArrayList<PetItem> {
    val list = ArrayList<PetItem>()
    this.forEach {
        list += PetItem(it)
    }

    return list
}

/**
 * @return Formatted match percent text
 */
fun Int.getMatchPercentText(context: Context): String {
    val percent = (this * 100) / Constants.MATCH_MAX
    return context.getString(R.string.match_percent_format, percent)
}