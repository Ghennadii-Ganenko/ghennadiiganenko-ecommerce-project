package com.ghennadiiganenko.android.ecommerce.domain.mapper

import com.ghennadiiganenko.android.ecommerce.domain.models.DeviceEntity
import com.ghennadiiganenko.android.ecommerce.domain.network.Device

class DeviceMapper : Mapper<Device, DeviceEntity>  {
    override fun map(input: Device): DeviceEntity = DeviceEntity(
        homeStore = input.homeStore,
        bestSeller = input.bestSeller
    )

}