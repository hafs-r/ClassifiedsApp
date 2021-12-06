package com.dubizzle.classifieds.domain.main.usecase

import com.dubizzle.classifieds.base.ApiListResponse
import com.dubizzle.classifieds.data.main.model.Classified
import com.dubizzle.classifieds.domain.main.repo.ClassifiedRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ClassifiedUseCase(private val repo: ClassifiedRepo) {
    suspend fun classifieds(): ApiListResponse<List<Classified>> =
        withContext(Dispatchers.IO) { repo.classifieds() }
}