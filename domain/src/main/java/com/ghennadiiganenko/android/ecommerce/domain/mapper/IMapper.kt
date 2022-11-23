package com.ghennadiiganenko.android.ecommerce.domain.mapper

interface IMapper<I, O> {
    fun map(input: I): O
}