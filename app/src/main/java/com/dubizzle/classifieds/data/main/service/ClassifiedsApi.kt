package com.dubizzle.classifieds.data.main.service

import com.dubizzle.classifieds.base.ApiListResponse
import com.dubizzle.classifieds.data.main.model.Classified
import retrofit2.http.GET

interface ClassifiedsApi {

    @GET("default/dynamodb-writer")
    suspend fun classifieds() : ApiListResponse<List<Classified>>
}