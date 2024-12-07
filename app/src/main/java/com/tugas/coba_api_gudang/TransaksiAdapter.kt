package com.tugas.coba_api_gudang

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tugas.coba_api_gudang.databinding.ItemTransaksiBinding

class TransaksiAdapter(
    private val onClick: (Transaksi) -> Unit
) : ListAdapter<Transaksi, TransaksiAdapter.TransaksiViewHolder>(TransaksiDiffCallback()) {

    class TransaksiViewHolder(val binding: ItemTransaksiBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiViewHolder {
        val binding = ItemTransaksiBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TransaksiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransaksiViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.apply {
            namaBarang.text = data.barang_nama
            jumlahBarang.text = data.jumlah_barang.toString()
            tatolHargaBarang.text = data.total_harga_barang.toString()

            // Set onClick listener
            root.setOnClickListener {
                onClick(data)
            }
        }
    }

    class TransaksiDiffCallback : DiffUtil.ItemCallback<Transaksi>() {
        override fun areItemsTheSame(oldItem: Transaksi, newItem: Transaksi): Boolean {
            return oldItem.id_transaksi == newItem.id_transaksi
        }

        override fun areContentsTheSame(oldItem: Transaksi, newItem: Transaksi): Boolean {
            return oldItem == newItem
        }
    }
}