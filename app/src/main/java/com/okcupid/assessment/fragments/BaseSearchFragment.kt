package com.okcupid.assessment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.okcupid.assessment.adapters.PetListAdapter
import com.okcupid.assessment.databinding.PetListLayoutBinding
import com.okcupid.assessment.entities.LoadResult
import com.okcupid.assessment.viewModels.BaseViewModel

/**
 * Base Fragment with abstract [search] function
 *
 * @see PetListLayoutBinding
 */
abstract class BaseSearchFragment: Fragment() {

    // ViewModel
    abstract val viewModel: BaseViewModel

    // Binding variable
    lateinit var binding: PetListLayoutBinding

    protected val adapter = PetListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.fetchData()
        }
    }

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

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it == LoadResult.LOADING
            binding.recyclerview.isVisible = it == LoadResult.SUCCESS
        }
        viewModel.petList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.fetchData(true)
    }

    abstract fun search(keyword: String)
}