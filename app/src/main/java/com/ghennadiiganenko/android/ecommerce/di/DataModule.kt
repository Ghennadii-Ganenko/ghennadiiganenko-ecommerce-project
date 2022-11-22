package com.ghennadiiganenko.android.ecommerce.di

import com.ghennadiiganenko.android.ecommerce.data.repository.DeviceDetailsRepository
import com.ghennadiiganenko.android.ecommerce.data.repository.DeviceRepository
import org.koin.dsl.module

val dataModule = module {
    single {
        DeviceRepository()
    }
    single {
        DeviceDetailsRepository()
    }
}