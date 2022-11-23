package com.ghennadiiganenko.android.ecommerce

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.text.style.UnderlineSpan
import java.text.DecimalFormat


object TextHelper {

    fun strikeText(text: String) =
        SpannableString(text).apply {
            setSpan(StrikethroughSpan(), 0, length, Spanned.SPAN_PARAGRAPH)
        }

//    fun underlineText(text: String) =
//        SpannableString(text).apply {
//            setSpan(UnderlineSpan(), 0, length, Spanned.SPAN_PARAGRAPH)
//        }
//
//    fun decimalFormat(v: Float) = DecimalFormat("@@##").format(v)

    fun addDollarSign(text: String) = "$$text"

    fun addGbText(text: String) = "$text GB"
}