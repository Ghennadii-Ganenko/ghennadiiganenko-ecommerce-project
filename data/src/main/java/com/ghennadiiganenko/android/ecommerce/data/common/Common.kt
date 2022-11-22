package com.ghennadiiganenko.android.ecommerce.data.common

import com.ghennadiiganenko.android.ecommerce.data.client.RetrofitClient
import com.ghennadiiganenko.android.ecommerce.data.interfaces.RetrofitService

object Common {
    private const val BASE_URL = "https://run.mocky.io/v3/"
    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}