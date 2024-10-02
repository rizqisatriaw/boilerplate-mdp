package id.maxxitani.compose.data.remote

import retrofit2.http.GET
import retrofit2.http.Headers

interface HelloWorldServices {
    @Headers("@: Auth")
    @GET("field-officer/mobile/v1/agronomist/team")
    suspend fun getHelloWorld()
}