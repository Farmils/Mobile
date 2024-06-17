package com.example.pokemonmobile.UI.models

import androidx.lifecycle.ViewModel
import com.example.pokemonmobile.UI.screen.MainScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainScreenViewModel:ViewModel() {
    private val _stateMainScreen = MutableStateFlow(MainScreenState())
    val stateMainScreen = _stateMainScreen.asStateFlow()

    fun changeStateSort(state: MainScreenStateSort) {
        when (state) {
            MainScreenStateSort.NAME -> {
                _stateMainScreen.update {
                    it.copy(isNumberSorted = false, isNameSorted = true)
                }
            }

            MainScreenStateSort.NUMBER -> {
                _stateMainScreen.update {
                    it.copy(isNumberSorted = true, isNameSorted = false)

                }
            }
        }
    }
}

