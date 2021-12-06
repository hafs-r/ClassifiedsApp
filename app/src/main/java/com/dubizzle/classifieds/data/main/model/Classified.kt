package com.dubizzle.classifieds.data.main.model
import com.dubizzle.classifieds.base.BaseDataModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Classified (
    val created_at: String,
    val price: String,
    val name: String,
    val uid: String,
    val image_ids: List<String>,
    val image_urls: List<String>,
    val image_urls_thumbnails: List<String>
) : BaseDataModel()
