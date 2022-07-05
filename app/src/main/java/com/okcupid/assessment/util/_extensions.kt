package com.okcupid.assessment.util

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