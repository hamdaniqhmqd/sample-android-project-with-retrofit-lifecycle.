package com.tugas.coba_api_gudang

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstanceTransaksi {

    private const val BASE_URL = "https://gudang-pakaian-api.infitechd.my.id/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiTransaksi by lazy {
        retrofit.create(ApiTransaksi::class.java)
    }
}
