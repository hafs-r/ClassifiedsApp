package com.dubizzle.classifieds.base

import com.squareup.moshi.JsonClass

open class BaseApiResponse

open class BaseDataModel

@JsonClass(generateAdapter = true)
data class Pagination(
    val key: String?,
)

@JsonClass(generateAdapter = true)
data class ApiListResponse<T : List<BaseDataModel>>(
    val results: T,
    val pagination: Pagination,
) : BaseApiResponse()