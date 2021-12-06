package com.dubizzle.classifieds.domain.main.repo

import com.dubizzle.classifieds.base.ApiListResponse
import com.dubizzle.classifieds.data.main.model.Classified

interface ClassifiedRepo {
    suspend fun classifieds(): ApiListResponse<List<Classified>>
}