package com.example.assignment1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.assignment1.ui.screens.BookListScreen
import com.example.assignment1.ui.theme.Assignment1Theme
import com.example.assignment1.ui.theme.getGenreColorScheme
import com.example.assignment1.viewmodel.BookListViewModel

class BookListActivity : ComponentActivity() {

    companion object {
        const val EXTRA_GENRE = "extra_genre"
    }

    private val viewModel: BookListViewModel by viewModels()
    private var currentGenre: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        currentGenre = intent.getStringExtra(EXTRA_GENRE)
        viewModel.loadBooks(currentGenre)

        setContent {
            // Determine ColorScheme based on the genre from the Intent
            val colorScheme = getGenreColorScheme(genre = currentGenre)

            // Apply the selected theme
            Assignment1Theme(colorScheme = colorScheme) {
                val books by viewModel.books.collectAsState()

                BookListScreen(
                    genre = currentGenre,
                    books = books,
                    onBookSelected = { selectedBookId ->
                        navigateToBookDetail(selectedBookId)
                    },
                    onNavigateBack = {
                        finish() // Back to MainActivity
                    }
                )
            }
        }
    }

    private fun navigateToBookDetail(bookId: String) {
        val intent = Intent(this, BookDetailActivity::class.java).apply {
            putExtra(BookDetailActivity.EXTRA_BOOK_ID, bookId)
        }

        startActivity(intent)
    }
}