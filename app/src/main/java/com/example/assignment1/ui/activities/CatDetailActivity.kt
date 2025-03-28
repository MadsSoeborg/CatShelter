package com.example.assignment1.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.assignment1.ui.screens.CatDetailScreen
import com.example.assignment1.ui.theme.Assignment1Theme
import com.example.assignment1.ui.theme.getCategoryColorScheme
import com.example.assignment1.viewmodel.CatDetailViewModel // Use CatDetailViewModel

class CatDetailActivity : ComponentActivity() {

    companion object {
        const val EXTRA_CAT_ID = "extra_cat_id"
    }

    private val viewModel: CatDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val catId = intent.getStringExtra(EXTRA_CAT_ID)
        viewModel.loadCat(catId)

        setContent {
            val cat by viewModel.cat.collectAsState()

            // Determine the ColorScheme based on the loaded cat's category
            val currentCatCategory = cat?.category
            val colorScheme = getCategoryColorScheme(category = currentCatCategory)

            Assignment1Theme(colorScheme = colorScheme) {
                CatDetailScreen(
                    cat = cat,
                    onNavigateBack = {
                        finish() // Back to CatListActivity
                    }
                )
            }
        }
    }
}