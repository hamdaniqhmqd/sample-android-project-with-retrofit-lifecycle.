package com.tugas.coba_api_gudang

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TransaksiViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TransaksiRepository = TransaksiRepository()

    private val _transaksiList = MutableLiveData<List<Transaksi>>()
    val transaksiList: LiveData<List<Transaksi>> get() = _transaksiList

    private val _transaksiDetail = MutableLiveData<Transaksi>()
    val transaksiDetail: LiveData<Transaksi> get() = _transaksiDetail

    private val _statusMessage = MutableLiveData<String>()
    val statusMessage: LiveData<String> get() = _statusMessage

    // Mendapatkan semua transaksi
    fun getTransaksi() {
        viewModelScope.launch {
            try {
                val response = repository.getTransaksi()
                if (response.success) {
                    _transaksiList.postValue(response.data)
                } else {
                    _statusMessage.postValue(response.message)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _statusMessage.postValue("Kesalahan saat memuat data transaksi.")
            }
        }
    }

    // Mendapatkan transaksi berdasarkan ID
    fun getTransaksiById(id: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getTransaksiById(id)
                if (response.success) {
                    _transaksiDetail.postValue(response.data) // Mengambil transaksi yang ada
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // Menambahkan transaksi baru
    fun addTransaksi(transaksi: Transaksi) {
        viewModelScope.launch {
            try {
                val response = repository.addTransaksi(transaksi)
                if (response.success) {
                    _statusMessage.postValue("Transaksi berhasil ditambahkan.")
                    getTransaksi() // Refresh data
                } else {
                    _statusMessage.postValue(response.message)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _statusMessage.postValue("Kesalahan saat menambahkan transaksi.")
            }
        }
    }

    // Mengedit transaksi
    fun updateTransaksi(id: Int, transaksi: Transaksi) {
        viewModelScope.launch {
            try {
                val response = repository.updateTransaksi(id, transaksi)
                if (response.success) {
                    _statusMessage.postValue("Transaksi berhasil diperbarui.")
                    getTransaksi() // Refresh data
                } else {
                    _statusMessage.postValue(response.message)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _statusMessage.postValue("Kesalahan saat memperbarui transaksi.")
            }
        }
    }

    // Menghapus transaksi
    fun deleteTransaksi(id: Int) {
        viewModelScope.launch {
            try {
                val response = repository.deleteTransaksi(id)
                if (response.success) {
                    _statusMessage.postValue("Transaksi berhasil dihapus.")
                    getTransaksi() // Refresh data
                } else {
                    _statusMessage.postValue(response.message)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _statusMessage.postValue("Kesalahan saat menghapus transaksi.")
            }
        }
    }
}



