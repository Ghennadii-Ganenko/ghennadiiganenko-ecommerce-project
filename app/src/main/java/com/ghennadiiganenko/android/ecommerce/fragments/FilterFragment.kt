package com.ghennadiiganenko.android.ecommerce.fragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghennadiiganenko.android.ecommerce.R
import com.ghennadiiganenko.android.ecommerce.databinding.FragmentFilterBinding

class FilterFragment : DialogFragment(R.layout.fragment_my_cart) {

    private var binding: FragmentFilterBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFilterBinding.inflate(inflater, container, false)
        this.binding = binding

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setWindowParams()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            this?.closeButton?.setOnClickListener {
                navigateBack()
            }

            this?.doneButton?.setOnClickListener {
                navigateBack()
            }

            this?.filterEmptyView?.setOnClickListener {
                navigateBack()
            }
        }

        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.Brands,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding?.brandSpinner?.adapter = adapter
            }

            ArrayAdapter.createFromResource(
                it,
                R.array.Prices,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding?.priceSpinner?.adapter = adapter
            }

            ArrayAdapter.createFromResource(
                it,
                R.array.Sizes,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding?.sizeSpinner?.adapter = adapter
            }
        }

    }

    private fun setWindowParams(){
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
    }

    private fun navigateBack() = findNavController().popBackStack()
}