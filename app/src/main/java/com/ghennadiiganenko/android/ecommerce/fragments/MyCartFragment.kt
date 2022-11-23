package com.ghennadiiganenko.android.ecommerce.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghennadiiganenko.android.ecommerce.R
import com.ghennadiiganenko.android.ecommerce.adapter.CartDevicesAdapter
import com.ghennadiiganenko.android.ecommerce.databinding.FragmentMyCartBinding
import com.ghennadiiganenko.android.ecommerce.viewmodels.MainViewModel
import org.koin.androidx.navigation.koinNavGraphViewModel
import kotlin.properties.Delegates

class MyCartFragment : Fragment(R.layout.fragment_my_cart) {

    private var binding: FragmentMyCartBinding by Delegates.notNull()
    private val viewModel by koinNavGraphViewModel<MainViewModel>(R.id.device_graph)
    private lateinit var cartDevicesAdapter: CartDevicesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyCartBinding.inflate(inflater, container, false)

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val devicesCount = viewModel.devicesCount.value

        cartDevicesAdapter = CartDevicesAdapter(requireContext(), view)
        binding.cartDevicesRecyclerview.adapter = cartDevicesAdapter

        viewModel.deviceDetailsList.observe(viewLifecycleOwner) { result ->
            cartDevicesAdapter.submitList(devicesCount?.let { MutableList(it) { result } })

            if (devicesCount != null)
                binding.totalPriceTextview.text = "$${(result.price * devicesCount)} us"
        }

        binding.apply {
            backButton.setOnClickListener {
                navigateBack()
            }
        }
    }

    private fun navigateBack() = findNavController().popBackStack()
}