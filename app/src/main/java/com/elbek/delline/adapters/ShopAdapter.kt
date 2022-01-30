package com.elbek.delline.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elbek.delline.databinding.ProductItemBinding
import com.elbek.delline.models.CategoriesModel
import com.elbek.delline.models.ProductData

class ShopAdapter(val list: ArrayList<ProductData>, val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {
    inner class ShopViewHolder(val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(productData: ProductData, position: Int) {
            binding.productName.text = productData.productName
            binding.productAbout.text = productData.productFunction
            binding.productPrice.text = productData.productPrice
            binding.productImage.setImageResource(productData.productImage)
            binding.root.setOnClickListener {
                onItemClickListener.onItemClick(productData)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        return ShopViewHolder(ProductItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount() = list.size

    interface OnItemClickListener {
        fun onItemClick(productData: ProductData)
    }
}