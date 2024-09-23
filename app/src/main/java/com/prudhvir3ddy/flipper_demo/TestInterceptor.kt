package com.prudhvir3ddy.flipper_demo

import okhttp3.Interceptor
import okhttp3.Response

class TestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        println(request)
        return chain.proceed(request)
    }

}
