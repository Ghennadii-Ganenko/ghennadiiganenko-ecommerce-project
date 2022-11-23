package com.ghennadiiganenko.android.ecommerce.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghennadiiganenko.android.ecommerce.R
import com.ghennadiiganenko.android.ecommerce.adapter.BestSellerAdapter
import com.ghennadiiganenko.android.ecommerce.adapter.HotSalesAdapter
import com.ghennadiiganenko.android.ecommerce.databinding.FragmentMainBinding
import com.ghennadiiganenko.android.ecommerce.domain.models.BestSellerDeviceEntity
import com.ghennadiiganenko.android.ecommerce.viewmodels.MainViewModel
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import org.koin.androidx.navigation.koinNavGraphViewModel
import kotlin.properties.Delegates


class MainFragment : Fragment(R.layout.fragment_main), BestSellerAdapter.ItemClickListener {

    private var binding: FragmentMainBinding by Delegates.notNull()
    private val viewModel by koinNavGraphViewModel<MainViewModel>(R.id.device_graph)
    private lateinit var bestSellerAdapter: BestSellerAdapter
    private lateinit var hotSalesAdapter: HotSalesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
            .apply {
                bottomNavigationBar.setItemSelected(R.id.action_explorer, true)
            }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bestSellerAdapter = BestSellerAdapter(this,requireContext(), view)
        hotSalesAdapter = HotSalesAdapter(requireContext(), view)

        binding.bestSellerRecyclerview.adapter = bestSellerAdapter
        binding.hotSalesRecyclerview.adapter = hotSalesAdapter

        viewModel.devicesList.observe(viewLifecycleOwner) { result ->
            bestSellerAdapter.submitList(result.bestSeller)
            hotSalesAdapter.submitList(result.homeStore)
        }

        viewModel.getDevicesList()

        binding.apply {
            filterImagebutton.setOnClickListener {
                navigateToFilterFragment()
            }

            bottomNavigationBar.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
                override fun onItemSelected(id: Int) {
                    when (id) {
                        R.id.action_cart -> navigateToCartFragment()
                    }
                }
            })
        }

        viewModel.devicesCount.observe(viewLifecycleOwner) {
            if(it != 0)
                binding.bottomNavigationBar.showBadge(R.id.action_cart, it)
        }
    }

    override fun onItemClicked(item: BestSellerDeviceEntity, view: View) {
        navigateToProductDetailsFragment()
    }

    private fun navigateToFilterFragment() = findNavController().navigate(R.id.action_mainFragment_to_filterFragment)

    private fun navigateToProductDetailsFragment() = findNavController().navigate(R.id.action_mainFragment_to_productDetailsFragment)

    private fun navigateToCartFragment() = findNavController().navigate(R.id.action_mainFragment_to_myCartFragment)
}