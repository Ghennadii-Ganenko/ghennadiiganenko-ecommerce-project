package com.ghennadiiganenko.android.ecommerce.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ghennadiiganenko.android.ecommerce.R
import com.ghennadiiganenko.android.ecommerce.TextHelper
import com.ghennadiiganenko.android.ecommerce.databinding.ItemCartDeviceBinding
import com.ghennadiiganenko.android.ecommerce.databinding.ItemHotSalesBinding
import com.ghennadiiganenko.android.ecommerce.domain.models.DeviceDetailsEntity
import com.squareup.picasso.Picasso

class CartDevicesAdapter(
    private val context: Context,
    private val view: View
) : ListAdapter<DeviceDetailsEntity, RecyclerView.ViewHolder>(ItemsDiffCallback()) {

    private class ItemsDiffCallback : DiffUtil.ItemCallback<DeviceDetailsEntity>() {
        override fun areItemsTheSame(
            oldItem: DeviceDetailsEntity,
            newItem: DeviceDetailsEntity
        ): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: DeviceDetailsEntity,
            newItem: DeviceDetailsEntity
        ): Boolean =
            oldItem == newItem
    }

    inner class CartDeviceViewHolder(private val binding: ItemCartDeviceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DeviceDetailsEntity) {
            binding.apply {

                Picasso.get().load(item.images[0]).into(deviceImage)
                deviceNameTextview.text = item.title
                devicePriceTextview.text = TextHelper.addDollarSign(item.price.toString())
                amountTextview.text = "1"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartDeviceViewHolder =
        CartDeviceViewHolder(
            ItemCartDeviceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val packHolder = holder as CartDeviceViewHolder
        packHolder.bind(item)
    }
}