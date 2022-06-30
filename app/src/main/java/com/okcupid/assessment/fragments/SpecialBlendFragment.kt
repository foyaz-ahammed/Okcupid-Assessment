package com.okcupid.assessment.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.okcupid.assessment.entities.PetItem

/**
 * Fragment for the Special Blend page (shows all pets)
 */
class SpecialBlendFragment: BaseSearchFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = listOf(
            PetItem("1", "aaa", 26, "US", "NJ", "Jersey City", "https://static.okccdn.com/interview/Animals/Medium/quinn.jpg", 9102, true),
            PetItem("2", "bbb", 28, "US", "NJ", "Jersey City", "https://static.okccdn.com/interview/Animals/Medium/quinn.jpg", 9102, true),
        )
        adapter.submitList(list)
    }

    override fun search(keyword: String) {
        TODO("Not yet implemented")
    }
}