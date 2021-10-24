package com.dicoding.foodapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvFoods: RecyclerView
    private var list: ArrayList<Food> = arrayListOf()
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFoods = findViewById(R.id.rv_Foods)
        rvFoods.setHasFixedSize(true)

        list.addAll(FoodsData.listData)
        showRecylerList()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun showRecylerList() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFoods.adapter = listFoodAdapter

        listFoodAdapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                showSelectedFood(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvFoods.layoutManager = GridLayoutManager(this, 2)
        val gridFoodAdapter = GridFoodAdapter(list)
        rvFoods.adapter = gridFoodAdapter

        gridFoodAdapter.setOnClickItemCallback(object : GridFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                showSelectedFood(data)
            }
        })
    }

    private fun showRecylerCardVIew() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val cardViewFoodAdapter = CardViewFoodAdapter(list)
        rvFoods.adapter = cardViewFoodAdapter

        cardViewFoodAdapter.setOnClickItemCallback((object : CardViewFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                showSelectedFood(data)
            }
        }))

    }

    private fun showSelectedFood(food: Food) {
        val foodDetailIntent = Intent(this@MainActivity, DetailFoodActivity::class.java)
        foodDetailIntent.putExtra(DetailFoodActivity.EXTRA_NAME, food.name)
        foodDetailIntent.putExtra(DetailFoodActivity.EXTRA_DETAIL, food.detail)
        foodDetailIntent.putExtra(DetailFoodActivity.EXTRA_TITLE, food.titleDetail)
        foodDetailIntent.putExtra(DetailFoodActivity.EXTRA_FULL, food.full)
        foodDetailIntent.putExtra(DetailFoodActivity.EXTRA_TITLECOMPS, food.titleCompositionFood)
        foodDetailIntent.putExtra(DetailFoodActivity.EXTRA_COMPOSITION, food.composition)

        foodDetailIntent.putExtra("resource", food.photo)
        startActivity(foodDetailIntent)
    }

//    Set Action Bar

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }


    private fun setMode(selectedMode: Int) {
        when(selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecylerList()
            }

            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }

            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecylerCardVIew()
            }
        }
    setActionBarTitle(title)
    }

    override fun onClick(p0: View?) {
    }
}