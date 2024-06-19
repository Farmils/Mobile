package com.example.pokemonmobile.UI.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.pokemonmobile.PokemonApplication
import com.example.pokemonmobile.UI.screen.MainScreen
import com.example.pokemonmobile.data.model.PokemonItemResponse
import com.example.pokemonmobile.data.model.PokemonItemsResponse
import com.example.pokemonmobile.data.model.PokemonResponse
import com.example.pokemonmobile.data.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.internal.cache.CacheStrategy

class MainScreenViewModel(private val repository: PokemonRepository):ViewModel() {
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
    fun getPokemons(){
        _stateMainScreen.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPokemons().collect { result ->
                _stateMainScreen.update {
                    it.copy(
                        isLoading = false,
                        pokemonList = result
                    )
                }
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = object :ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application= checkNotNull(extras[APPLICATION_KEY])
                return MainScreenViewModel((application as PokemonApplication).repository) as T
            }
        }
    }
}

