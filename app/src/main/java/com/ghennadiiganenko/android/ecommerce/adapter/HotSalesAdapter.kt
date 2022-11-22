package com.ghennadiiganenko.android.ecommerce.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ghennadiiganenko.android.ecommerce.databinding.ItemHotSalesBinding
import com.ghennadiiganenko.android.ecommerce.domain.models.HomeStoreDeviceEntity
import com.squareup.picasso.Picasso

class HotSalesAdapter(
    private val context: Context,
    private val view: View
) : ListAdapter<HomeStoreDeviceEntity, RecyclerView.ViewHolder>(ItemsDiffCallback()) {

    private class ItemsDiffCallback : DiffUtil.ItemCallback<HomeStoreDeviceEntity>() {
        override fun areItemsTheSame(
            oldItem: HomeStoreDeviceEntity,
            newItem: HomeStoreDeviceEntity
        ): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: HomeStoreDeviceEntity,
            newItem: HomeStoreDeviceEntity
        ): Boolean =
            oldItem == newItem
    }

    inner class HotSalesViewHolder(private val binding: ItemHotSalesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeStoreDeviceEntity) {
            binding.apply {

                deviceName.text = item.title
                Picasso.get().load(item.picture).into(deviceImage)
                deviceDescription.text = item.subtitle
                if (item.is_new) {
                    newIcon.visibility = View.VISIBLE
                } else {
                    newIcon.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesViewHolder =
        HotSalesViewHolder(
            ItemHotSalesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val packHolder = holder as HotSalesViewHolder
        packHolder.bind(item)
    }
}