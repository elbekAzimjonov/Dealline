package com.elbek.delline.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elbek.delline.R
import com.elbek.delline.adapters.BrandAdapter
import com.elbek.delline.itemDecloration.ItemDeclaration
import com.elbek.delline.models.BrandModel
import java.util.*
import kotlin.collections.ArrayList

class BrandsFragment : Fragment() {
    lateinit var list: ArrayList<BrandModel>
    lateinit var brandAdapter: BrandAdapter
    lateinit var brandRecycler: RecyclerView
    lateinit var backButton: ImageView
    lateinit var editSearch: EditText
    var filterList = ArrayList<BrandModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val views = inflater.inflate(R.layout.fragment_brends, container, false)
        backButton = views.findViewById(R.id.onBack)
        editSearch = views.findViewById(R.id.editSearch)
        editSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                filter(p0.toString())
            }

        })
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        list = ArrayList()
        list.add(BrandModel("Samsung", R.drawable.samsung_image))
        list.add(BrandModel("Chigo", R.drawable.chigo))
        list.add(BrandModel("Artel", R.drawable.artel))
        list.add(BrandModel("Lg", R.drawable.lg))
        list.add(BrandModel("Philips", R.drawable.philips))
        list.add(BrandModel("Panasonic", R.drawable.panasonic))
        list.add(BrandModel("Indesit", R.drawable.indesit))
        list.add(BrandModel("Pioneer", R.drawable.pionneer))
        list.add(BrandModel("Beko", R.drawable.beko))
        list.add(BrandModel("Sony", R.drawable.sony))
        list.add(BrandModel("Mi", R.drawable.mi))
        list.add(BrandModel("Apple", R.drawable.apple))
        list.add(BrandModel("Huawei", R.drawable.huawei))
        list.add(BrandModel("Canon", R.drawable.canon))
        brandRecycler = views.findViewById(R.id.brendRecycler)
        brandRecycler.layoutManager = GridLayoutManager(requireActivity(), 2)


        brandAdapter = BrandAdapter(list, object : BrandAdapter.OnItemClickListener {
            override fun onItemClick(brandModel: BrandModel) {
                var bundle: Bundle
                bundle = Bundle()
                bundle = bundleOf("brandName" to brandModel)
                Navigation.findNavController(views)
                    .navigate(R.id.action_brendsFragment_to_catigoriesFragment, bundle)
            }

        })

        brandRecycler.adapter = brandAdapter
        return views
    }

    fun filter(fil: String) {
        filterList = ArrayList()
        for (item in list) {
            if (item.brandName.lowercase()
                    .contains(fil.lowercase())
            ) {
                filterList.add(item)
                brandAdapter.filterList(filterList)
            }
        }
    }
}