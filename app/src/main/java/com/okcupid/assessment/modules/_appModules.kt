package com.okcupid.assessment.modules

import com.okcupid.assessment.repository.OkcupidRepository
import com.okcupid.assessment.repository.PetAPI
import com.okcupid.assessment.util.Constants
import com.okcupid.assessment.viewModels.BaseViewModel
import com.okcupid.assessment.viewModels.MatchPercentViewModel
import com.okcupid.assessment.viewModels.SpecialBlendViewModel
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val repositoryModule = module {
    single { OkcupidRepository(get()) }
    single { provideAPI(get()) }
    single { provideRetrofit(get(), get()) }
    single { provideOkHttpClient() }
    single { provideMoshi() }
}

val viewModelModule = module {
    viewModel { SpecialBlendViewModel(get()) }
    viewModel { MatchPercentViewModel(get()) }
}

/**
 * @return Instance of [Retrofit]
 */
private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    moshi: Moshi
): Retrofit =
    Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()

/**
 * @return Instance of [OkHttpClient]
 */
private fun provideOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .readTimeout(10L, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

/**
 * @return Instance of [Moshi]
 */
private fun provideMoshi(): Moshi = Moshi.Builder().build()

/**
 * @return Instance of [PetAPI]
 */
private fun provideAPI(retrofit: Retrofit): PetAPI = retrofit.create(PetAPI::class.java)