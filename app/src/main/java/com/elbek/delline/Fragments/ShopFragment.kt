package com.elbek.delline.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elbek.delline.R
import com.elbek.delline.adapters.ShopAdapter
import com.elbek.delline.adapters.ShopItemDecloration
import com.elbek.delline.itemDecloration.ItemDeclaration
import com.elbek.delline.models.CategoriesModel
import com.elbek.delline.models.ProductData
import com.elbek.delline.ui.ViewActivty

class ShopFragment : Fragment() {
    lateinit var productList: ArrayList<ProductData>
    lateinit var shopRecycler: RecyclerView
    lateinit var shopAdapter: ShopAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val views = inflater.inflate(R.layout.fragment_shop, container, false)
        productList = ArrayList()
        shopRecycler = views.findViewById(R.id.fragmentShopRecycler)
        shopRecycler.addItemDecoration(
            ShopItemDecloration(
                18,
                18
            )
        )
        val bundle = arguments
        if (bundle != null) {
            val productData = bundle.getParcelable<CategoriesModel>("fragmentProduct")
            productList = productData?.products!!
        }

        shopRecycler = views.findViewById(R.id.fragmentShopRecycler)
        shopAdapter = ShopAdapter(productList, object : ShopAdapter.OnItemClickListener {
            override fun onItemClick(productData: ProductData) {
                val intent = Intent(requireActivity(), ViewActivty::class.java)
                intent.putExtra("productName", productData.productName)
                intent.putExtra("productFunction", productData.productFunction)
                intent.putExtra("productRating", productData.productRating)
                intent.putExtra("productOrginalPrice", productData.productOrginalPrice)
                intent.putExtra("productPrice", productData.productPrice)
                intent.putExtra("productImage", productData.productImage)
                startActivity(intent)
            }
        })
        shopRecycler.layoutManager = GridLayoutManager(requireActivity(), 2)
        shopRecycler.adapter = shopAdapter
        return views
    }

}