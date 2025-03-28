package com.example.assignment1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assignment1.data.Cat
import com.example.assignment1.data.CatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CatListViewModel : ViewModel() {
    private val _cats = MutableStateFlow<List<Cat>>(emptyList())
    val cats: StateFlow<List<Cat>> = _cats.asStateFlow()

    fun loadCats(category: String?) {
        if (category != null) {
            _cats.value = CatRepository.getCatsByCategory(category)
        } else {
            _cats.value = emptyList()
        }
    }
}