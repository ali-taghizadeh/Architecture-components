package ir.taghizadeh.deezer.data.network.config

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        Observable.just(isOnline())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { t -> if (!t) Log.e("NetworkException", "No internet connection")}
            .subscribe()

        return chain.proceed(chain.request())
    }

    private fun isOnline(): Boolean {
        return try {
            val sock = Socket()
            sock.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            sock.close()
            true
        } catch (e: IOException) {
            false
        }
    }
}