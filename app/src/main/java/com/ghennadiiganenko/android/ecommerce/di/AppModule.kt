package com.ghennadiiganenko.android.ecommerce.di

import com.ghennadiiganenko.android.ecommerce.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            deviceRepository = get(),
            deviceDetailsRepository = get()
        )
    }
}