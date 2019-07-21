package ir.taghizadeh.deezer.data.network.config

import com.safframework.http.interceptor.LoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    operator fun invoke(): Retrofit {

        val CONNECTION_TIMEOUT: Long = 10
        val READ_TIMEOUT: Long = 10

        val loggingInterceptor = LoggingInterceptor.Builder()
            .loggable(true)
            .request()
            .requestTag("Request")
            .response()
            .responseTag("Response")
            .build()

        val okHttpClient = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(HeadersInterceptor())
            .addInterceptor(loggingInterceptor)
            .addInterceptor(NetworkInterceptor())
            .build()

        val builder = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.deezer.com/")
            .addConverterFactory(GsonConverterFactory.create())

        return builder.build()
    }

    fun <T> buildService(serviceType: Class<T>): T {
        return invoke().create(serviceType)
    }

}