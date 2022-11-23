package com.ghennadiiganenko.android.ecommerce.domain.mapper

import com.ghennadiiganenko.android.ecommerce.domain.models.DeviceDetailsEntity
import com.ghennadiiganenko.android.ecommerce.domain.network.DeviceDetails

class DeviceDetailsMapper : IMapper<DeviceDetails, DeviceDetailsEntity>  {
    override fun map(input: DeviceDetails): DeviceDetailsEntity = DeviceDetailsEntity(
        cpu = input.cpu,
        camera = input.camera,
        capacity = input.capacity,
        color = input.color,
        id = input.id,
        images = input.images,
        isFavorites = input.isFavorites,
        price = input.price,
        rating = input.rating,
        sd = input.sd,
        ssd = input.ssd,
        title = input.title
    )

}