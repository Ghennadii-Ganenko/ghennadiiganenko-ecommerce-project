package com.ghennadiiganenko.android.ecommerce.data.interfaces

import com.ghennadiiganenko.android.ecommerce.data.DeviceData
import com.ghennadiiganenko.android.ecommerce.data.DeviceDetailsData
import retrofit2.Call
import retrofit2.http.GET

interface IRetrofitService {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    fun getDevices(): Call<DeviceData>

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    fun getDevicesDetails(): Call<DeviceDetailsData>
}