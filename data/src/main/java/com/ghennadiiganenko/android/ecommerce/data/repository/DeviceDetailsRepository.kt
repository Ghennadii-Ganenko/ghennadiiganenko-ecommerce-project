package com.ghennadiiganenko.android.ecommerce.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ghennadiiganenko.android.ecommerce.data.DeviceDetailsData
import com.ghennadiiganenko.android.ecommerce.data.common.Common
import com.ghennadiiganenko.android.ecommerce.data.interfaces.IRetrofitService
import com.ghennadiiganenko.android.ecommerce.domain.mapper.DeviceDetailsMapper
import com.ghennadiiganenko.android.ecommerce.domain.models.DeviceDetailsEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeviceDetailsRepository {
    private lateinit var mService: IRetrofitService
    val devicesList = MutableLiveData<DeviceDetailsEntity>()

    fun getDevicesDetailsList() {
        mService = Common.retrofitService
        val deviceDetailsMapper = DeviceDetailsMapper()
        mService.getDevicesDetails().enqueue(object : Callback<DeviceDetailsData> {
            override fun onFailure(call: Call<DeviceDetailsData>, t: Throwable) {
                Log.e("IsFailResponse", t.message.toString())
            }

            override fun onResponse(call: Call<DeviceDetailsData>, response: Response<DeviceDetailsData>) {
                if (response.isSuccessful) {
                    devicesList.postValue(response.body()?.let { deviceDetailsMapper.map(it) })
                } else {
                    Log.e("Critical", response.toString())
                }
            }
        })
    }
}