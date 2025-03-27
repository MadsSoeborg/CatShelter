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
                val genres by viewModel.genres.collectAsState()

                MainScreen(
                    genres = genres,
                    onGenreSelected = { selectedGenre ->
                        navigateToBookList(selectedGenre)
                    }
                )
            }
        }
    }

    private fun navigateToBookList(genre: String) {
        val intent = Intent(this, BookListActivity::class.java).apply {
            putExtra(BookListActivity.EXTRA_GENRE, genre)
        }
        startActivity(intent)
    }
}