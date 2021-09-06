package com.example.cleanarchitecture.data.remote.interceptor

import android.content.Context
import okhttp3.*
import javax.inject.Inject


class HeaderInterceptor @Inject constructor(
    private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
            request = request?.newBuilder()
                ?.addHeader("Content-Type", "application/json")
                ?.addHeader("Accept", "application/json")
                ?.build()
        return chain.proceed(request)
    }

}