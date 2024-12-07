package com.tugas.coba_api_gudang

import com.google.gson.annotations.SerializedName

data class TransaksiResponseDetail(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: Transaksi
)
