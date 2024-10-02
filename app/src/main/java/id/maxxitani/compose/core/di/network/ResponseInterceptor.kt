package id.maxxitani.compose.core.di.network

import android.util.Log
import id.maxxitani.compose.core.common.ErrorMessageConstant
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.security.cert.CertificateException

class ResponseInterceptor : Interceptor {
    var retrofit: Retrofit? = null
    var getToken: (() -> String)? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val headers = request.headers.values("@")
        val token =
            runBlocking {}
        if (headers.contains("Auth")) {
            val builder = request.newBuilder()
            builder.addHeader("Authorization", "Bearer $token")
            request = builder.removeHeader("@").build()
        }
        val response =
            try {
                chain.proceed(request)
            } catch (error: Exception) {
                val message =
                    when (error) {
                        is UnknownHostException -> ErrorMessageConstant.INTERNAL_SERVER_ERROR
                        is SocketTimeoutException -> ErrorMessageConstant.REQUEST_TIME_OUT
                        is CertificateException -> "Membutuhkan sambungan koneksi terpercaya"
                        is ConnectException -> ErrorMessageConstant.NO_CONNECTION
                        else -> "Something went wrong"
                    }
                throw IOException(message)
            }
        throwIfError(response)
        return response
    }

    private fun throwIfError(response: Response) {
        when (val code = response.code) {
            in 200..299 -> {
                return
            }

            400 -> {
                val exception = IOException(ErrorMessageConstant.BAD_REQUEST)
                Log.e("App response error", "$code", exception)
                throw exception
            }

            401 -> {
                val exception = IOException(ErrorMessageConstant.ACCOUNT_NOT_FOUND)
                Log.e("App response error", "$code", exception)
                throw exception
            }

            in 500..599 -> {
                val exception = IOException(ErrorMessageConstant.INTERNAL_SERVER_ERROR)
                Log.e("App response error", "$code", exception)
                throw exception
            }

            else -> {
            }
        }
    }
}
