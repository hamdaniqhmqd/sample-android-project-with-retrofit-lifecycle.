package com.tugas.coba_api_gudang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TransaksiRepository {
    private val transaksiApi: ApiTransaksi = RetrofitInstanceTransaksi.apiService

    suspend fun getTransaksi(): TransaksiResponse {
        return try {
            val response = transaksiApi.getTransaksi()
            if (response.success) {
                response
            } else {
                throw Exception("Failed to load data")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("Error fetching transaksi data: ${e.message}")
        }
    }

    // Mengambil transaksi berdasarkan ID
    suspend fun getTransaksiById(id: Int): TransaksiResponseDetail {
        return try {
            val response = transaksiApi.getTransaksiById(id)
            if (response.success) {
                response
            } else {
                throw Exception("Failed to load transaksi details")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("Error fetching transaksi by ID: ${e.message}")
        }
    }

    // Menambahkan transaksi baru
    suspend fun addTransaksi(transaksi: Transaksi): TransaksiResponse {
        return try {
            val response = transaksiApi.addTransaksi(transaksi)
            if (response.success) {
                response
            } else {
                throw Exception(response.message ?: "Gagal menambahkan transaksi.")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("Kesalahan saat menambahkan transaksi: ${e.message}")
        }
    }

    // Mengedit transaksi
    suspend fun updateTransaksi(id: Int, transaksi: Transaksi): TransaksiResponse {
        return try {
            val response = transaksiApi.updateTransaksi(id, transaksi)
            if (response.success) {
                response
            } else {
                throw Exception(response.message ?: "Gagal mengedit transaksi.")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("Kesalahan saat mengedit transaksi: ${e.message}")
        }
    }

    // Menghapus transaksi
    suspend fun deleteTransaksi(id: Int): TransaksiResponse {
        return try {
            val response = transaksiApi.deleteTransaksi(id)
            if (response.success) {
                response
            } else {
                throw Exception(response.message ?: "Gagal menghapus transaksi.")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("Kesalahan saat menghapus transaksi: ${e.message}")
        }
    }
}
