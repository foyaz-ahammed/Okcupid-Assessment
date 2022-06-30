package com.okcupid.assessment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.okcupid.assessment.adapters.PetListAdapter
import com.okcupid.assessment.databinding.PetListLayoutBinding

/**
 * Base Fragment with abstract [search] function
 *
 * @see PetListLayoutBinding
 */
abstract class BaseSearchFragment: Fragment() {

    // Binding variable
    protected lateinit var binding: PetListLayoutBinding

    protected val adapter = PetListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PetListLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.adapter = adapter
    }

    abstract fun search(keyword: String)
}