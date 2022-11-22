package com.ghennadiiganenko.android.ecommerce.domain.models

data class BestSellerDeviceEntity(
    val id: Int,
    val is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
)