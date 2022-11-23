package com.ghennadiiganenko.android.ecommerce.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghennadiiganenko.android.ecommerce.data.repository.DeviceDetailsRepository
import com.ghennadiiganenko.android.ecommerce.data.repository.DeviceRepository
import com.ghennadiiganenko.android.ecommerce.domain.models.DeviceDetailsEntity
import com.ghennadiiganenko.android.ecommerce.domain.models.DeviceEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val deviceRepository: DeviceRepository,
    private val deviceDetailsRepository: DeviceDetailsRepository,
) : ViewModel() {

    val devicesList: MutableLiveData<DeviceEntity> = deviceRepository.devicesList
    val deviceDetailsList: MutableLiveData<DeviceDetailsEntity> = deviceDetailsRepository.devicesList
    val devicesCount: MutableLiveData<Int> = MutableLiveData(0)

    fun addDevicesCount() {
        devicesCount.value = devicesCount.value?.plus(1)
    }

    fun getDevicesList() {
        viewModelScope.launch(Dispatchers.IO) {
            deviceRepository.getDevicesList()
        }
    }

    fun getDeviceDetailsList() {
        viewModelScope.launch(Dispatchers.IO) {
            deviceDetailsRepository.getDevicesDetailsList()
        }
    }
}