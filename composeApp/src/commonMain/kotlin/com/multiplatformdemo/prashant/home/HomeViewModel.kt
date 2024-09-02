package com.multiplatformdemo.prashant.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.multiplatform.domain.GetArticlesUc
import com.multiplatform.utility.Result.Error
import com.multiplatform.utility.Result.Success
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(val getArticlesUc: GetArticlesUc): ViewModel() {


    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow()


    init {
        getArticles()
    }

    private fun getArticles() = viewModelScope.launch {

        when (val result =getArticlesUc()) {
            is Error -> Unit
            is Success -> {
_state.value.article.clear()
_state.value.article.addAll(result.data.data.orEmpty())
            }
        }


    }



}