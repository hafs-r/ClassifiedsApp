package com.dubizzle.classifieds.data.main.repo

import com.dubizzle.classifieds.base.ApiListResponse
import com.dubizzle.classifieds.data.main.model.Classified
import com.dubizzle.classifieds.data.main.service.ClassifiedsApi
import com.dubizzle.classifieds.domain.main.repo.ClassifiedRepo

class ClassifiedRepoImpl(private val service: ClassifiedsApi) : ClassifiedRepo {
    override suspend fun classifieds(): ApiListResponse<List<Classified>> {
        return service.classifieds()
    }
}