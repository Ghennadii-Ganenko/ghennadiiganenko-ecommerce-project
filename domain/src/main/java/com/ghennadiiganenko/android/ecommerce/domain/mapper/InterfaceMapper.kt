package com.ghennadiiganenko.android.ecommerce.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}