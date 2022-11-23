package com.ghennadiiganenko.android.ecommerce.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ghennadiiganenko.android.ecommerce.data.DeviceData
import com.ghennadiiganenko.android.ecommerce.data.common.Common
import com.ghennadiiganenko.android.ecommerce.data.interfaces.IRetrofitService
import com.ghennadiiganenko.android.ecommerce.domain.mapper.DeviceMapper
import com.ghennadiiganenko.android.ecommerce.domain.models.DeviceEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeviceRepository {
    private lateinit var mService: IRetrofitService
    val devicesList = MutableLiveData<DeviceEntity>()

    fun getDevicesList() {
        mService = Common.retrofitService
        val deviceMapper = DeviceMapper()
        mService.getDevices().enqueue(object : Callback<DeviceData> {
            override fun onFailure(call: Call<DeviceData>, t: Throwable) {
                Log.e("IsFailResponse", t.message.toString())
            }

            override fun onResponse(call: Call<DeviceData>, response: Response<DeviceData>) {
                if (response.isSuccessful) {
                    devicesList.postValue(response.body()?.let { deviceMapper.map(it) })
                } else {
                    Log.e("Critical", response.toString())
                }
            }
        })
    }
}