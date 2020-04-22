package com.example.orderhw.bucket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderhw.R
import kotlinx.android.synthetic.main.bucket_item.view.*

class BucketAdapter(
    private val onDelete: (string: String) -> Unit
) : RecyclerView.Adapter<BucketAdapter.ViewHolder>() {
    private var products: List<String> = listOf()

    override fun getItemCount(): Int = products.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BucketAdapter.ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.bucket_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    fun setItems(products: List<String>) {
        this.products = products
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String) {
            itemView.basketTv.text = text
            itemView.basketDeleteIb.setOnClickListener { onDelete(text) }
        }
    }
}