package com.ghennadiiganenko.android.ecommerce.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ghennadiiganenko.android.ecommerce.TextHelper
import com.ghennadiiganenko.android.ecommerce.databinding.ItemBestSellerBinding
import com.ghennadiiganenko.android.ecommerce.domain.models.BestSellerDeviceEntity
import com.squareup.picasso.Picasso

class BestSellerAdapter(
    private val clickListener: ItemClickListener,
    private val context: Context,
    private val view: View,
) : ListAdapter<BestSellerDeviceEntity, RecyclerView.ViewHolder>(ItemsDiffCallback()) {

    private class ItemsDiffCallback : DiffUtil.ItemCallback<BestSellerDeviceEntity>() {
        override fun areItemsTheSame(
            oldItem: BestSellerDeviceEntity,
            newItem: BestSellerDeviceEntity
        ): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: BestSellerDeviceEntity,
            newItem: BestSellerDeviceEntity
        ): Boolean =
            oldItem == newItem
    }

    inner class BestSellerViewHolder(private val binding: ItemBestSellerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BestSellerDeviceEntity) {
            binding.apply {
                root.setOnClickListener {
                    it.isClickable = false
                    it.postDelayed({ it.isClickable = true }, 1000)
                    clickListener.onItemClicked(item, view)
                }

                deviceName.text = item.title
                deviceActualPrice.text =
                    TextHelper.strikeText(
                        TextHelper.addDollarSign(
                            item.discount_price.toString()
                        )
                    )
                deviceDiscountPrice.text = TextHelper.addDollarSign(
                    item.price_without_discount.toString()
                )
                Picasso.get().load(item.picture).into(deviceImage)
                favouriteButton.isChecked = item.is_favorites
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder =
        BestSellerViewHolder(
            ItemBestSellerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val packHolder = holder as BestSellerViewHolder
        packHolder.bind(item)
    }

    interface ItemClickListener {
        fun onItemClicked(item: BestSellerDeviceEntity, view: View)
    }
}