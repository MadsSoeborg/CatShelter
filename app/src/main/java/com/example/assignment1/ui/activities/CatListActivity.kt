package com.example.assignment1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.assignment1.ui.screens.CatListScreen
import com.example.assignment1.ui.theme.Assignment1Theme
import com.example.assignment1.ui.theme.getCategoryColorScheme
import com.example.assignment1.viewmodel.CatListViewModel

class CatListActivity : ComponentActivity() {

    companion object {
        const val EXTRA_CATEGORY = "extra_category"
    }

    private val viewModel: CatListViewModel by viewModels()
    private var currentCategory: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        currentCategory = intent.getStringExtra(EXTRA_CATEGORY)
        viewModel.loadCats(currentCategory)

        setContent {
            // Determine ColorScheme based on the category
            val colorScheme = getCategoryColorScheme(category = currentCategory)

            Assignment1Theme(colorScheme = colorScheme) {
                val cats by viewModel.cats.collectAsState()

                CatListScreen(
                    category = currentCategory,
                    cats = cats,
                    onCatSelected = { selectedCatId ->
                        navigateToCatDetail(selectedCatId)
                    },
                    onNavigateBack = {
                        finish()
                    }
                )
            }
        }
    }

    private fun navigateToCatDetail(catId: String) {
        val intent = Intent(this, CatDetailActivity::class.java).apply {
            putExtra(CatDetailActivity.EXTRA_CAT_ID, catId)
        }
        startActivity(intent)
    }
}