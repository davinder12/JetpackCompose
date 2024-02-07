package com.example.jetpackcomposearchitecutre.dagger

import com.example.jetpackcomposearchitecutre.api.TweetsyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkCall {


    @Singleton
    @Provides
    fun providesRetrofit(httpClient: OkHttpClient):Retrofit {
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .client(httpClient).addConverterFactory(GsonConverterFactory.create()).build()
    }
    //

    @Singleton
    @Provides
    fun provideTweetsyApi(retrofit: Retrofit): TweetsyApi{
         return retrofit.create(TweetsyApi::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val httpClient = OkHttpClient.Builder().apply {
            readTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS)
        }
        httpClient.addInterceptor { chain ->
            val ongoing = chain.request().newBuilder()
            ongoing.addHeader("Content-Type", "application/json;charset=utf-8")
            ongoing.addHeader("Accept", "application/json; application/problem+json")
            val response = chain.proceed(ongoing.build())
            response
        }
        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    companion object {
        private const val HTTP_TIMEOUT = 40L
    }
}