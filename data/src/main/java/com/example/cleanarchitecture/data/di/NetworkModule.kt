package com.example.cleanarchitecture.data.di

import com.example.cleanarchitecture.data.remote.api.NewsFeedApi
import com.example.cleanarchitecture.data.remote.builder.RetrofitBuilder
import com.example.cleanarchitecture.data.remote.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(retrofitBuilder: RetrofitBuilder, headerInterceptor: HeaderInterceptor): Retrofit = retrofitBuilder
        .addInterceptors(headerInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideNewfeedApi(retrofit: Retrofit): NewsFeedApi  = retrofit.create(NewsFeedApi::class.java)
}