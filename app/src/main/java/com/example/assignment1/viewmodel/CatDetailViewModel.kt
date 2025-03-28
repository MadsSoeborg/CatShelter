package com.example.assignment1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assignment1.data.Cat
import com.example.assignment1.data.CatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CatDetailViewModel : ViewModel() {
    private val _cat = MutableStateFlow<Cat?>(null)
    val cat: StateFlow<Cat?> = _cat.asStateFlow()

    fun loadCat(catId: String?) {
        if (catId != null) {
            _cat.value = CatRepository.getCatById(catId)
        } else {
            _cat.value = null
        }
    }
}