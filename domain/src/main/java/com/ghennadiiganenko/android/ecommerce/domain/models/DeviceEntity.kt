package com.ghennadiiganenko.android.ecommerce.domain.models

data class DeviceEntity(
    val homeStore: List<HomeStoreDeviceEntity>,
    val bestSeller: List<BestSellerDeviceEntity>
)