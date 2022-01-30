package com.elbek.delline.ui

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.elbek.delline.R
import com.elbek.delline.ViewModel.MainViewModel
import com.elbek.delline.models.DeallineData

class ViewActivty : AppCompatActivity() {
    lateinit var viewImage: ImageView
    lateinit var viewName: TextView
    lateinit var ratingBar: RatingBar
    lateinit var viewAbout: TextView
    lateinit var viewPrice: TextView
    lateinit var viewOrginalPrice: TextView
    lateinit var onBack: ImageView
    lateinit var addData: RelativeLayout
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_activty)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.initDatabase(this)
        viewImage = findViewById(R.id.viewImage)
        viewName = findViewById(R.id.viewName)
        ratingBar = findViewById(R.id.ratingBar_small)
        viewAbout = findViewById(R.id.view_about)
        viewOrginalPrice = findViewById(R.id.viewOrginalPrice)
        viewPrice = findViewById(R.id.facePrice)
        onBack = findViewById(R.id.ic_back)
        addData = findViewById(R.id.addData)
        val productName = intent.getStringExtra("productName")
        val productFunction = intent.getStringExtra("productFunction")
        val productRating = intent.getIntExtra("productRating", 0)
        val productOrginalPrice = intent.getStringExtra("productOrginalPrice")
        val productPrice = intent.getStringExtra("productPrice")
        val productImage = intent.getIntExtra("productImage", 1)
        viewImage.setImageResource(productImage)
        viewName.text = productName
        ratingBar.rating = productRating.toFloat()
        viewAbout.text = productFunction
        viewOrginalPrice.text = productOrginalPrice
        viewPrice.text = productPrice
        addData.setOnClickListener {
            mainViewModel.insertProduct(
                DeallineData(productImage,
                    productName.toString(),
                    productFunction.toString(),
                    productRating,
                    productOrginalPrice.toString(),
                    productPrice.toString())
            )
            Toast.makeText(this, "Successful add", Toast.LENGTH_SHORT).show()
        }
        onBack.setOnClickListener {
            finish()
        }
    }
}