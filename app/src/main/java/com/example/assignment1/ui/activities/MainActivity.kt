package com.example.assignment1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.assignment1.ui.screens.MainScreen
import com.example.assignment1.ui.theme.Assignment1Theme
import com.example.assignment1.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1Theme {
                val categories by viewModel.categories.collectAsState()

                MainScreen(
                    categories = categories,
                    onCategorySelected = { selectedCategory ->
                        navigateToCatList(selectedCategory)
                    }
                )
            }
        }
    }

    private fun navigateToCatList(category: String) {
        val intent = Intent(this, CatListActivity::class.java).apply {
            putExtra(CatListActivity.EXTRA_CATEGORY, category)
        }
        startActivity(intent)
    }
}