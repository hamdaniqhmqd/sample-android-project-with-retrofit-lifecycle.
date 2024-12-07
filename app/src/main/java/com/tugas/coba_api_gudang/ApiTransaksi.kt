package com.tugas.coba_api_gudang

import androidx.lifecycle.LiveData
import retrofit2.Response
import retrofit2.http.*

interface ApiTransaksi {
    @GET("/api/transaksi")
    suspend fun getTransaksi(): TransaksiResponse

    @GET("/api/transaksi/{id}")
    suspend fun getTransaksiById(@Path("id") id: Int): TransaksiResponseDetail

    @POST("api/transaksi")
    suspend fun addTransaksi(@Body transaksi: Transaksi): TransaksiResponse

    @PUT("api/transaksi/{id}")
    suspend fun updateTransaksi(@Path("id") id: Int, @Body transaksi: Transaksi): TransaksiResponse

    @DELETE("transaksi/{id}")
    suspend fun deleteTransaksi(@Path("id") id: Int): TransaksiResponse
}
