package com.aadil.assingment.retrofit

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CommonApi {

    @GET("nzin01312019187360.json")
    suspend fun getTeam() : Response<ResponseBody>


    companion object{
        operator fun invoke() : CommonApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://cricket.yahoo.net/sifeeds/cricket/live/json/")
                .build()
                .create(CommonApi::class.java)
        }
    }
}
