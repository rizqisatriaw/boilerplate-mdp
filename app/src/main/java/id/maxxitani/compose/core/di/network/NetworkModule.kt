package id.maxxitani.compose.core.di.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.maxxitani.compose.BuildConfig
import id.maxxitani.compose.data.remote.HelloWorldServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val jsonChecker by lazy {
        ResponseJsonChecker
    }
    private val timeOut = 60

    @Provides
    @Singleton
    fun providesResponseInterceptor(): ResponseInterceptor {
        return ResponseInterceptor().apply {
            getToken = {
                ""
            }
        }
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        responseInterceptor: ResponseInterceptor,
    ): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(jsonChecker)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .also {
                responseInterceptor.retrofit = it
            }
    }

    @Provides
    @Singleton
    fun providesOkhttpClient(
        responseInterceptor: ResponseInterceptor,
        @ApplicationContext applicationContext: Context,
    ): OkHttpClient {
        val chuckerCollector =
            ChuckerCollector(
                context = applicationContext,
                showNotification = true,
                retentionPeriod = RetentionManager.Period.ONE_HOUR,
            )
        val chuckerInterceptor =
            ChuckerInterceptor.Builder(applicationContext)
                .collector(chuckerCollector)
                .maxContentLength(250_000L)
                .build()
        val builder =
            OkHttpClient.Builder()
                .addInterceptor(responseInterceptor)
//                .authenticator(customAuthenticator)
                .connectTimeout(timeOut.toLong(), TimeUnit.SECONDS)
                .readTimeout(timeOut.toLong(), TimeUnit.SECONDS)
                .writeTimeout(timeOut.toLong(), TimeUnit.SECONDS)
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY),
                ).also {
                    if (BuildConfig.DEBUG) {
                        it.addInterceptor(chuckerInterceptor)
                    }
                }
        return builder.build()
    }

    @Provides
    @Singleton
    fun providesHelloWorldServices(retrofit: Retrofit): HelloWorldServices {
        return retrofit.create(HelloWorldServices::class.java)
    }
}