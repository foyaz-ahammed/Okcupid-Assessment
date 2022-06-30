package com.okcupid.assessment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okcupid.assessment.R
import com.okcupid.assessment.databinding.RowPetBinding
import com.okcupid.assessment.entities.PetItem
import com.okcupid.assessment.extensions.getMatchPercentText

/**
 * [ListAdapter] for [PetItem]
 */
class PetListAdapter: ListAdapter<PetItem, PetListAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RowPetBinding = RowPetBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    object DiffCallback: DiffUtil.ItemCallback<PetItem>() {

        override fun areItemsTheSame(oldItem: PetItem, newItem: PetItem): Boolean {
            return oldItem.userid == newItem.userid
        }

        override fun areContentsTheSame(oldItem: PetItem, newItem: PetItem): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(private val binding: RowPetBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PetItem) {
            binding.name.text = item.username
            binding.address.text = String.format("%s • %s, %s, %s", item.age, item.cityName, item.stateCode, item.countryCode)
            binding.matchPercent.text = item.match.getMatchPercentText(binding.root.context)

            Glide.with(binding.root.context)
                .load(item.photo)
                .into(binding.image)

            binding.root.setOnClickListener {  }
        }

    }
}