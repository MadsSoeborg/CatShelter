package com.example.assignment1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assignment1.data.Book
import com.example.assignment1.data.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BookDetailViewModel : ViewModel() {
    private val _book = MutableStateFlow<Book?>(null)
    val book: StateFlow<Book?> = _book.asStateFlow()

    fun loadBook(bookId: String?) {
        if (bookId != null) {
            _book.value = BookRepository.getBookById(bookId)
        } else {
            _book.value = null // Handle case where ID is missing
        }
    }
}