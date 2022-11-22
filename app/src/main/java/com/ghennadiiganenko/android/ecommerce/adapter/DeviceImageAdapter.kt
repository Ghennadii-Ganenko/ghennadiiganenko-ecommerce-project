package com.ghennadiiganenko.android.ecommerce.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ghennadiiganenko.android.ecommerce.databinding.ItemProductDetailsDeviceImageBinding
import com.squareup.picasso.Picasso

class DeviceImageAdapter(
    private val context: Context,
    private val view: View
) : ListAdapter<String, RecyclerView.ViewHolder>(ItemsDiffCallback()) {

    private class ItemsDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean =
            oldItem == newItem
    }

    inner class DeviceImageViewHolder(private val binding: ItemProductDetailsDeviceImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.apply {

                Picasso.get().load(item).into(deviceImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceImageViewHolder =
        DeviceImageViewHolder(
            ItemProductDetailsDeviceImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val packHolder = holder as DeviceImageViewHolder
        packHolder.bind(item)
    }
}