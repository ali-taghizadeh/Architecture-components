package ir.taghizadeh.deezer.data.network

import com.safframework.http.interceptor.LoggingInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val requestInterceptor = Interceptor { chain ->
        val url = chain.request()
            .url()
            .newBuilder()
            .build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        return@Interceptor chain.proceed(request)
    }

    private val loggingInterceptor = LoggingInterceptor.Builder()
        .loggable(true)
        .request()
        .requestTag("Request")
        .response()
        .responseTag("Response")
        .build()

    private val okHttpClient = OkHttpClient.Builder()
        .writeTimeout((30 * 1000).toLong(), TimeUnit.MILLISECONDS)
        .readTimeout((20 * 1000).toLong(), TimeUnit.MILLISECONDS)
        .connectTimeout((15 * 1000).toLong(), TimeUnit.MILLISECONDS)
        .addInterceptor(requestInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    private val builder = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://api.deezer.com/")
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}