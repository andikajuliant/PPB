package com.dicoding.foodapps

object FoodsData {

    private val foodNames = arrayOf("Ati Ampela",
            "Ayam Goreng",
            "Goreng Tempe",
            "Ikan Bawal",
            "Sambel Goreng Tempe",
            "Sate Usus",
            "Sop",
            "Tauge",
            "Telur Dadar",
            "Tempe Orek")

    private val foodsDetail = arrayOf("Harga : Rp 9.000 \n\n",
            "Harga : Rp 10.000 \n\n",
            "Harga : Rp 6.000 \n\n",
            "Harga : Rp 8.000 \n\n",
            "Harga : Rp 7.000 \n\n",
            "Harga : Rp 7.500 \n\n",
            "Harga : Rp 6.500 \n\n",
            "Harga : Rp 4.000 \n\n",
            "Harga : Rp 7.000 \n\n",
            "Harga : Rp 5.000 \n\n")

    private val foodsImages = intArrayOf(R.drawable.ati_ampela,
            R.drawable.ayam_goreng,
            R.drawable.gorengan_tempe,
            R.drawable.ikan_bawal,
            R.drawable.sambel_goreng_kentang,
            R.drawable.sate_usus,
            R.drawable.sop,
            R.drawable.tauge,
            R.drawable.telur_dadar,
            R.drawable.tempe_orek)



    val listData: ArrayList<Food>
        get() {
            val list = arrayListOf<Food>()
            for (position in foodNames.indices) {
                val food = Food()
                food.name = foodNames[position]
                food.detail = foodsDetail[position]
                food.photo = foodsImages[position]
                list.add(food)
            }
            return list
        }
}