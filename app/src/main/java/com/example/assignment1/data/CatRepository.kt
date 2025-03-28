package com.example.assignment1.data

import com.example.assignment1.R

object CatRepository {

    private val cats = listOf(
        Cat("c1", "Mittens", "Cute", "1 year", "Female", "A very fluffy and affectionate kitty who loves naps in sunbeams. Needs a calm home.", R.drawable.cat_mittens), // Replace with your actual drawable IDs
        Cat("c2", "Shadow", "Cool", "3 years", "Male", "Sleek black cat, independent but enjoys quiet company. Master of stealth.", R.drawable.cat_shadow),
        Cat("c3", "Luna", "Calm", "5 years", "Female", "A gentle soul looking for a peaceful retirement home. Loves chin scratches.", R.drawable.cat_luna),
        Cat("c4", "Leo", "Cute", "6 months", "Male", "Playful and energetic kitten, loves chasing laser pointers and feather wands.", R.drawable.cat_leo),
        Cat("c5", "Ninja", "Cool", "2 years", "Male", "Likes observing from high places. Can be shy at first but warms up with patience.", R.drawable.cat_ninja),
        Cat("c6", "Patches", "Cute", "4 years", "Female", "A sweet calico who enjoys gentle pets and a warm lap. Gets along well with other cats.", R.drawable.cat_patches),
        Cat("c7", "Zephyr", "Calm", "7 years", "Male", "Very laid back and easygoing. Prefers lounging over playing. Great companion cat.", R.drawable.cat_zephyr)
        // Add more cats as needed...
    )

    fun getAllCategories(): List<String> {
        return listOf("Cute", "Cool", "Calm").filter { category ->
            cats.any { it.category.equals(category, ignoreCase = true) }
        }
    }

    fun getCatsByCategory(category: String): List<Cat> {
        return cats.filter { it.category.equals(category, ignoreCase = true) }
    }

    fun getCatById(id: String): Cat? {
        return cats.find { it.id == id }
    }
}