package com.example.assignment1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assignment1.data.Book
import com.example.assignment1.data.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BookListViewModel : ViewModel() {
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books.asStateFlow()

    fun loadBooks(genre: String?) {
        if (genre != null) {
            _books.value = BookRepository.getBooksByGenre(genre)
        } else {
            _books.value = emptyList() // Handle case where genre is missing
        }
    }
}