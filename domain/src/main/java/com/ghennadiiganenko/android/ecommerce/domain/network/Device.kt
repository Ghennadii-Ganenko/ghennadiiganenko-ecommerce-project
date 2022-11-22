package com.ghennadiiganenko.android.ecommerce.domain.network

import com.ghennadiiganenko.android.ecommerce.domain.models.BestSellerDeviceEntity
import com.ghennadiiganenko.android.ecommerce.domain.models.HomeStoreDeviceEntity

interface Device {
    val homeStore: List<HomeStoreDeviceEntity>
    val bestSeller: List<BestSellerDeviceEntity>
}