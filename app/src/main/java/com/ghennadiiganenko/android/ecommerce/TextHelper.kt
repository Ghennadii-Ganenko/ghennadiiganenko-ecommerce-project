package com.ghennadiiganenko.android.ecommerce

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.text.style.UnderlineSpan
import java.text.DecimalFormat


class TextHelper {
    fun strikeText(text: String?): SpannableString {
        var text = text
        if (text == null) text = ""
        val str = SpannableString(text)
        str.setSpan(StrikethroughSpan(), 0, str.length, Spanned.SPAN_PARAGRAPH)
        return str
    }

    fun underlineText(text: String?): SpannableString {
        var text = text
        if (text == null) text = ""
        val str = SpannableString(text)
        str.setSpan(UnderlineSpan(), 0, str.length, Spanned.SPAN_PARAGRAPH)
        return str
    }

    fun decimalFormat(v: Float): String = DecimalFormat("@@##").format(v)

    fun addDollarSign(text: String?): String = "$$text"

    fun addGbText(text: String?): String = "$text GB"
}