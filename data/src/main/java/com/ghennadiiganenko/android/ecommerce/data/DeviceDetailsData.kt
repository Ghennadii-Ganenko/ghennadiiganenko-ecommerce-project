package com.ghennadiiganenko.android.ecommerce.data

import com.ghennadiiganenko.android.ecommerce.domain.network.DeviceDetails
import com.google.gson.annotations.SerializedName

class DeviceDetailsData : DeviceDetails {
    @SerializedName("CPU")
    override val cpu: String = ""

    override val camera: String = ""

    override val capacity: List<String> = listOf()

    override val color: List<String> = listOf()

    override val id: String = ""

    override val images: List<String> = listOf()

    override val isFavorites: Boolean = false

    override val price: Int = 0

    override val rating: Double = 0.0

    override val sd: String = ""

    override val ssd: String = ""

    override val title: String = ""
}