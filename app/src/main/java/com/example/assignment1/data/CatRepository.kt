package com.example.assignment1.data

import com.example.assignment1.R

object CatRepository {

    // Cats and their info are taken from Dyrenes Beskyttelse
    // Descriptions have been run through Google Translate
    private val cats = listOf(
        Cat("c1", "Maximus", "Cute", "2 years", "Male", 3.0, "Maximus is a calm, gentle and loving cat who enjoys contact and cuddles, and who likes to give his people cuddles. He is curious and inquisitive, but always at a quiet and calm pace, taking in the world with a calm gaze.", R.drawable.maximus),
        Cat("c2", "Johanne", "Cool", "3 years", "Female", 3.6, "Johanne has been found as a stray. She was found with Frida. She is very cautious and a little nervous here at the shelter, but otherwise seems like a sweet and calm cat. She is looking for a quiet home where she can live as an indoor and outdoor cat.", R.drawable.johanne),
        Cat("c3", "Larsen", "Sad", "1 year", "Male", 2.85, "Larsen came to us through an animal welfare case with his brother, Kim. They are very scared here at the shelter, and the new owner must agree to spend a lot of time on socialization. They should preferably be adopted out together in a new home. They should not go out to children or other animals. They should both live as indoor and outdoor cats.", R.drawable.larsen),
        Cat("c4", "Frida", "Cute", "2 years", "Female", 3.17, "Frida has been found as a stray. She was found with Johanne. She is very cautious and a little nervous here at the shelter, but otherwise seems like a sweet and calm cat. She is looking for a quiet home where she can live as an indoor and outdoor cat.", R.drawable.frida),
        Cat("c5", "Samson", "Cool", "4 years", "Male", 5.2, "Samson is a big boy who would be great as a barn cat, but would also be able to function as an indoor/outdoor cat on a farm. Samson wants to cuddle, but out of the blue, he says stop, by snapping away. Samson comes from a case with many other cats, and would be able to get along with other younger cats. Samson is clean, and uses a litter box.", R.drawable.samson),
        Cat("c6", "Sorte", "Cute", "3 years", "Male", 2.9, "Sorte came to us because his previous owner could no longer have him. He has been an indoor cat all his life, but shows signs of wanting to go outside, and his energy level is also there. He will therefore live as an indoor and outdoor cat in a new home.", R.drawable.sorte),
        Cat("c7", "Kim", "Sad", "1 year", "Male", 3.07, "Kim came to us through an animal welfare case with his brother, Larsen. They are very scared here at the shelter, and the new owner must agree to spend a lot of time on socialization. They should preferably be adopted out together in a new home. They should not go out to children or other animals. They should both live as indoor and outdoor cats.", R.drawable.kim),
        Cat("c8", "Snow", "Sad", "1 year", "Male", 4.3, "Meet Snow! A sweet, curious and cuddly cat who is looking for a lovely home. He will live as an indoor and outdoor cat.", R.drawable.snow)
    )

    fun getAllCategories(): List<String> {
        return listOf("Cute", "Cool", "Sad").filter { category ->
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