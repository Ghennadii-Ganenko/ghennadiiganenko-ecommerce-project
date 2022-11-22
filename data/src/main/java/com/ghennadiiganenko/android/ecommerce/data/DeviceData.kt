package com.ghennadiiganenko.android.ecommerce.data

import com.ghennadiiganenko.android.ecommerce.domain.models.BestSellerDeviceEntity
import com.ghennadiiganenko.android.ecommerce.domain.models.HomeStoreDeviceEntity
import com.ghennadiiganenko.android.ecommerce.domain.network.Device
import com.google.gson.annotations.SerializedName

class DeviceData : Device {
    @SerializedName("home_store")
    override val homeStore: List<HomeStoreDeviceEntity> = listOf()

    @SerializedName("best_seller")
    override val bestSeller: List<BestSellerDeviceEntity> = listOf()
}