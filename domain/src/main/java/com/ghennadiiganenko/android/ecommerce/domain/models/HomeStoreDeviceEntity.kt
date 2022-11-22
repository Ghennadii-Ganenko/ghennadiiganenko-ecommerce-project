package com.ghennadiiganenko.android.ecommerce.domain.models

data class HomeStoreDeviceEntity(
    val id: Int,
    val is_new: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
)