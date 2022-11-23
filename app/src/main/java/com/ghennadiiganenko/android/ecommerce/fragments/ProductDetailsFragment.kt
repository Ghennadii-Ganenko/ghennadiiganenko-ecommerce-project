package com.ghennadiiganenko.android.ecommerce.fragments


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghennadiiganenko.android.ecommerce.CustomCarouselZoomPostLayoutListener
import com.ghennadiiganenko.android.ecommerce.R
import com.ghennadiiganenko.android.ecommerce.TextHelper
import com.ghennadiiganenko.android.ecommerce.adapter.DeviceImageAdapter
import com.ghennadiiganenko.android.ecommerce.databinding.FragmentProductDetailsBinding
import com.ghennadiiganenko.android.ecommerce.domain.models.DeviceDetailsEntity
import com.ghennadiiganenko.android.ecommerce.viewmodels.MainViewModel
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CenterScrollListener
import org.koin.androidx.navigation.koinNavGraphViewModel
import kotlin.properties.Delegates


class ProductDetailsFragment :
    Fragment(R.layout.fragment_product_details) {

    private var binding: FragmentProductDetailsBinding by Delegates.notNull()
    private val viewModel by koinNavGraphViewModel<MainViewModel>(R.id.device_graph)
    private lateinit var deviceDetailsAdapter: DeviceImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, false)
        layoutManager.setPostLayoutListener(CustomCarouselZoomPostLayoutListener())

        deviceDetailsAdapter = DeviceImageAdapter(requireContext(), view)

        binding.deviceImageRecyclerview.apply {
            this.layoutManager = layoutManager
            setHasFixedSize(true)
            adapter = deviceDetailsAdapter
            addOnScrollListener(CenterScrollListener())
        }

        viewModel.deviceDetailsList.observe(viewLifecycleOwner) { result ->
            deviceDetailsAdapter.submitList(result.images)
            inflateScreen(result)
        }

        viewModel.getDeviceDetailsList()

        binding.apply {
            backButton.setOnClickListener { navigateBack() }
            addToCartButton.setOnClickListener { viewModel.addDevicesCount() }
            cartButton.setOnClickListener { navigateToCartFragment() }
        }
    }

    private fun inflateScreen(result: DeviceDetailsEntity) {
        binding.apply {
            cpuTextview.text = result.cpu
            cameraTextview.text = result.camera
            firstSdRadiobutton.text = TextHelper.addGbText(result.capacity[0])
            secondSdRadiobutton.text = TextHelper.addGbText(result.capacity[1])
            sdTextview.text = result.sd
            ssdTextview.text = result.ssd
            deviceName.text = result.title
            productDetailsRatingbar.rating = result.rating.toFloat()
            addToCartPriceTextview.text = TextHelper.addDollarSign(result.price.toString())
            firstColorRadiobutton.background.setTint(Color.parseColor(result.color[0]))
            secondColorRadiobutton.background.setTint(Color.parseColor(result.color[1]))
            favouriteButton.isChecked = result.isFavorites
        }
    }

    private fun navigateBack() = findNavController().popBackStack()

    private fun navigateToCartFragment() =
        findNavController().navigate(R.id.action_productDetailsFragment_to_myCartFragment)
}