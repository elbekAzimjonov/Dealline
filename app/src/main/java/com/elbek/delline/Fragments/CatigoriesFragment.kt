package com.elbek.delline.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elbek.delline.R
import com.elbek.delline.adapters.CategoriesAdapter
import com.elbek.delline.models.BrandModel
import com.elbek.delline.models.ProductData
import com.elbek.delline.models.CategoriesModel


class CatigoriesFragment : Fragment() {
    lateinit var categoryAdapter: CategoriesAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var backButton: ImageView
    lateinit var changeLayout: ImageView
    lateinit var brandModel: BrandModel
    lateinit var categorylist: ArrayList<CategoriesModel>
    lateinit var productData: ArrayList<ProductData>
    lateinit var refrigerators: ArrayList<ProductData>
    lateinit var washing: ArrayList<ProductData>
    lateinit var holodilnik: ArrayList<ProductData>
    lateinit var smartphones: ArrayList<ProductData>
    lateinit var fragmentProduct: FragmentContainerView
    lateinit var brandName: TextView
    lateinit var categoryName: TextView
    lateinit var productName: TextView
    lateinit var searchView: SearchView
    lateinit var middleContainer: LinearLayout
    lateinit var category: ArrayList<CategoriesModel>
    private var isClickChek: Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val views = inflater.inflate(R.layout.fragment_catigories, container, false)
        recyclerView = views.findViewById(R.id.categoriesRecycler)
        backButton = views.findViewById(R.id.onBack)
        changeLayout = views.findViewById(R.id.changeLayout)
        fragmentProduct = views.findViewById(R.id.shop_container_view)
        categoryName = views.findViewById(R.id.middle_text)
        brandName = views.findViewById(R.id.brandName)
        productName = views.findViewById(R.id.productName)
        searchView = views.findViewById(R.id.searchCategory)
        middleContainer = views.findViewById(R.id.middle_container)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                filter(p0.toString())
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filter(p0.toString())
                return false
            }

        })

        changeLayout.setOnClickListener {
            if (isClickChek) {
                recyclerView.layoutManager = GridLayoutManager(requireActivity(), 3)
                recyclerView.adapter = categoryAdapter
                changeLayout.setImageResource(R.drawable.ic_vector_layout)
                fragmentProduct.visibility = View.INVISIBLE
                categoryName.visibility = View.INVISIBLE
                middleContainer.visibility = View.INVISIBLE
                isClickChek = false
            } else {
            }
        }
        arguments?.let { bundle ->
            brandModel = bundle.getParcelable("brandName")!!
        }
        brandName.text = brandModel.brandName
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        categorylist = ArrayList()
        productData = ArrayList()
        refrigerators = ArrayList()
        washing = ArrayList()
        smartphones = ArrayList()
        holodilnik = ArrayList()
        smartphones.add(
            ProductData(
                R.drawable.produt_holodilnik,
                "Samsung RT6000K 530л",
                "Функция Power Cool",
                "Система Twin Cooling Plus",
                4,
                "2 100 000 сум",
                "1 995 000 сум"
            )
        )
        washing.add(
            ProductData(
                R.drawable.haier,
                "Haier HW60-1029A",
                "Функция Power Cool",
                "Система Twin Cooling Plus",
                3,
                "2 100 000 сум",
                "1 995 000 сум"
            )
        )
        washing.add(
            ProductData(
                R.drawable.haier1,
                "Haier HW80-14636",
                "Функция Power Cool",
                "Система Twin Cooling Plus",
                4,
                "2 100 000 сум",
                "1 995 000 сум"
            )
        )
        washing.add(
            ProductData(
                R.drawable.samsung_washing,
                "Samsung WW60J4210HSULD",
                "Функция Power Cool",
                "Система Twin Cooling Plus",
                5,
                "2 100 000 сум",
                "1 995 000 сум"
            )
        )

        refrigerators.add(
            ProductData(
                R.drawable.produt_holodilnik,
                "Samsung RT6000K 530л",
                "Функция Power Cool",
                "Система Twin Cooling Plus",
                4,
                "2 100 000 сум",
                "1 995 000 сум"
            )
        )

        refrigerators.add(
            ProductData(
                R.drawable.produt_holodilnik,
                "Samsung RT6000K 530л",
                "Функция Power Cool",
                "Система Twin Cooling Plus",
                4,
                "2 100 000 сум",
                "1 995 000 сум"
            )
        )

        holodilnik.add(
            ProductData(
                R.drawable.produt_holodilnik,
                "Samsung RT6000K 530л",
                "Функция Power Cool",
                "Система Twin Cooling Plus",
                4,
                "2 100 000 сум",
                "1 995 000 сум"
            )
        )

        holodilnik.add(
            ProductData(
                R.drawable.holdin,
                "Bosch KGN56LB304",
                "Функция Power Cool",
                "Система Twin Cooling Plus",
                3,
                "2 100 000 сум",
                "1 995 000 сум"
            )
        )
        holodilnik.add(
            ProductData(
                R.drawable.hofmann,
                "Hofmann HR-541SBS-DS",
                "Функция Power Cool",
                "Система Twin Cooling Plus",
                4,
                "2 100 000 сум",
                "1 995 000 сум"
            )
        )
        productData.add(
            ProductData(
                R.drawable.produt_holodilnik,
                "Samsung RT6000K 530л",
                "Функция Power Cool",
                "Система Twin Cooling Plus",
                4,
                "2 100 000 сум",
                "1 995 000 сум"
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.conditsioner,
                "кондиционеры",
                refrigerators.size,
                refrigerators
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.ic_holodilnik,
                "Холодильники",
                holodilnik.size,
                holodilnik
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.washing_cars,
                "Стиральные машины",
                washing.size,
                washing
            )
        )

        categorylist.add(
            CategoriesModel(
                R.drawable.gas_stoves,
                "Газовые плиты",
                productData.size,
                productData
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.mixers,
                "Миксеры",
                productData.size,
                productData
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.ic_smartphone,
                "Смартфоны",
                productData.size,
                productData
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.microwaves,
                "Микроволновки",
                productData.size,
                productData
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.cameras,
                "Фотоапараты",
                productData.size,
                productData
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.tv_set,
                "Телевизор",
                productData.size,
                productData
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.toasters,
                "Тостеры",
                productData.size,
                productData
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.fen,
                "Фень",
                productData.size,
                productData
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.tifaly,
                "Тифалы",
                productData.size,
                productData
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.vacuum,
                "Пелисос",
                productData.size,
                productData
            )
        )
        categorylist.add(
            CategoriesModel(
                R.drawable.extraction_fan,
                "Разжигать",
                productData.size,
                productData
            )
        )

        categorylist.add(
            CategoriesModel(
                R.drawable.tableware,
                "посуда",
                productData.size,
                productData
            )
        )

        categoryAdapter =
            CategoriesAdapter(categorylist, object : CategoriesAdapter.OnItemClickListener {
                override fun onItemClick(categoriesModel: CategoriesModel, position: Int) {
                    productName.visibility = View.VISIBLE
                    categoryName.visibility = View.VISIBLE
                    middleContainer.visibility = View.VISIBLE
                    if (isClickChek) {
                        val shopFragment = ShopFragment()
                        replaceFragment(shopFragment, categoriesModel)
                        categoryName.text = categoriesModel.categorieName
                        productName.text = categoriesModel.categorieName
                    } else {
                        val layoutManagerCustom = LinearLayoutManager(
                            requireActivity(),
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                        recyclerView.layoutManager = layoutManagerCustom
                        val shopFragment = ShopFragment()
                        replaceFragment(shopFragment, categoriesModel)
                        changeLayout.setImageResource(R.drawable.ic_grid)
                        recyclerView.adapter = categoryAdapter
                        fragmentProduct.visibility = View.VISIBLE
                        recyclerView.scrollToPosition(position)
                        categoryName.text = categoriesModel.categorieName
                        productName.text = categoriesModel.categorieName
                        isClickChek = true
                    }
                }
            })

        recyclerView.layoutManager = GridLayoutManager(requireActivity(), 3)
        recyclerView.adapter = categoryAdapter
        return views

    }

    fun filter(fil: String) {
        category = ArrayList()
        for (item in categorylist) {
            if (item.categorieName.lowercase()
                    .contains(fil.lowercase())
            ) {
                category.add(item)
                categoryAdapter.filterList(category)
            }
        }
    }

    fun replaceFragment(fragment: Fragment, categoriesModel: CategoriesModel) {
        val bundle = Bundle()
        bundle.putParcelable("fragmentProduct", categoriesModel)
        fragment.arguments = bundle
        val fragmentManager = childFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.shop_container_view, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }
}