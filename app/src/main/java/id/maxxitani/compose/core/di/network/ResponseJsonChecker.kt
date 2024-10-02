package id.maxxitani.compose.core.di.network

import android.util.Log
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.Type

object ResponseJsonChecker : Converter.Factory() {
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit,
    ): Converter<ResponseBody, *> {
        return Converter<ResponseBody, Any> {
            val delegate = retrofit.nextResponseBodyConverter<Any>(this, type, annotations)
            try {
                delegate.convert(it)
            } catch (error: Exception) {
                Log.e("maxii logger", "error: ${Gson().toJson(error.message)}")
                throw IOException(error.message)
            }
        }
    }
}