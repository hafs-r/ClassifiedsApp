package com.dubizzle.classifieds.di

import com.dubizzle.classifieds.BuildConfig
import com.dubizzle.classifieds.data.main.repo.ClassifiedRepoImpl
import com.dubizzle.classifieds.data.main.service.ClassifiedsApi
import com.dubizzle.classifieds.domain.main.repo.ClassifiedRepo
import com.dubizzle.classifieds.domain.main.usecase.ClassifiedUseCase
import com.dubizzle.classifieds.presentation.main.MainViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.addAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


private fun httpInterceptor() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
private fun basicOkHttpClient() = OkHttpClient.Builder().addInterceptor(httpInterceptor()).build()

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .client(basicOkHttpClient())
        .baseUrl(BuildConfig.BASE_URL)
        .build()
}

fun  provideClassifiedsApi(retrofit: Retrofit): ClassifiedsApi {
    return retrofit.create(ClassifiedsApi::class.java)
}


val networkModule = module {
    single { provideRetrofit() }
    factory { provideClassifiedsApi(get()) }
    factory<ClassifiedRepo> { ClassifiedRepoImpl(get()) }
    factory { ClassifiedUseCase(get()) }
}

val appModule = module {
    viewModel { MainViewModel(get()) }
}