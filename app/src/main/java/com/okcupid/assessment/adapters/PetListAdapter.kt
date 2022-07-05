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
import com.okcupid.assessment.util.getMatchPercentText

/**
 * [ListAdapter] for [PetItem]
 */
class PetListAdapter: ListAdapter<PetItem, PetListAdapter.ViewHolder>(DiffCallback) {

    private var itemClickListener: ((PetItem) -> Unit)? = null

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

    fun setItemClickListener(listener: ((PetItem) -> Unit)? = null) {
        this.itemClickListener = listener
    }

    object DiffCallback: DiffUtil.ItemCallback<PetItem>() {

        override fun areItemsTheSame(oldItem: PetItem, newItem: PetItem): Boolean {
            return oldItem.userId == newItem.userId
        }

        override fun areContentsTheSame(oldItem: PetItem, newItem: PetItem): Boolean {
            return oldItem == newItem
        }

    }

    /**
     * Clear memory when the view is recycled
     */
    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)

        holder.recycle()
    }

    inner class ViewHolder(private val binding: RowPetBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PetItem) {
            binding.name.text = item.userName
            binding.address.text = String.format("%s • %s, %s, %s", item.age, item.cityName, item.stateCode, item.countryCode)
            binding.matchPercent.text = item.match.getMatchPercentText(binding.root.context)
            Glide.with(binding.root.context)
                .load( if (item.liked) R.drawable.ic_star else R.drawable.ic_unstar )
                .into(binding.like)

            Glide.with(binding.root.context)
                .load(item.photo)
                .into(binding.image)

            binding.root.setOnClickListener {
                itemClickListener?.invoke(item)
            }
            binding.like.setOnClickListener {
                itemClickListener?.invoke(item)
            }
        }

        fun recycle() {
            Glide.with(binding.root.context).apply {
                clear(binding.like)
                clear(binding.image)
            }
        }

    }
}