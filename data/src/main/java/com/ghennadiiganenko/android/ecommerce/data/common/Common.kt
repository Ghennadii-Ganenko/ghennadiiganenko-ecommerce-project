package com.ghennadiiganenko.android.ecommerce.data.common

import com.ghennadiiganenko.android.ecommerce.data.client.RetrofitClient
import com.ghennadiiganenko.android.ecommerce.data.interfaces.IRetrofitService

object Common {
    private const val BASE_URL = "https://run.mocky.io/v3/"
    val retrofitService: IRetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(IRetrofitService::class.java)
}
