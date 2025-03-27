package com.example.assignment1.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.assignment1.ui.screens.BookDetailScreen
import com.example.assignment1.ui.theme.Assignment1Theme
import com.example.assignment1.ui.theme.getGenreColorScheme
import com.example.assignment1.viewmodel.BookDetailViewModel

class BookDetailActivity : ComponentActivity() {

    companion object {
        const val EXTRA_BOOK_ID = "extra_book_id"
    }

    private val viewModel: BookDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bookId = intent.getStringExtra(EXTRA_BOOK_ID)
        viewModel.loadBook(bookId)

        setContent {
            // Observe book state from ViewModel
            val book by viewModel.book.collectAsState()

            // Determine the ColorScheme based on the loaded book's genre
            val currentBookGenre = book?.genre
            val colorScheme = getGenreColorScheme(genre = currentBookGenre)

            // Apply the selected theme
            Assignment1Theme(colorScheme = colorScheme) {
                BookDetailScreen(
                    book = book,
                    onNavigateBack = {
                        finish() // Back to BookListActivity
                    }
                )
            }
        }
    }
}