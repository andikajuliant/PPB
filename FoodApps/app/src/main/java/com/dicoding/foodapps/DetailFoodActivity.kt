package com.dicoding.foodapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DetailFoodActivity: AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_FULL = "extra_full"
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_TITLECOMPS = "extra_titlecomps"
        const val EXTRA_COMPOSITION = "extra_composition"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)

        val bundle: Bundle? = intent.extras
        val resource: Int = bundle!!.getInt("resource")
        val imageView: ImageView = findViewById(R.id.img_item_photo)
        val nameReceived: TextView = findViewById(R.id.tv_item_name)
        val detailReceived: TextView = findViewById(R.id.tv_item_detail)


        val foodName = intent.getStringExtra(EXTRA_NAME)
        val foodDetail = intent.getStringExtra(EXTRA_DETAIL)
        val titleComps = intent.getStringExtra(EXTRA_TITLECOMPS)
        val compositionFood = intent.getStringExtra(EXTRA_COMPOSITION)


        val textName = "$foodName"
        val textDetail = "$foodDetail"



        imageView.setImageResource(resource)
        nameReceived.text = textName
        detailReceived.text = textDetail

    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_buy -> {
                val text = "Anda membeli makanan ini"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this@DetailFoodActivity,text,duration)
                toast.show()
            }
        }
    }
}