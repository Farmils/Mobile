package com.example.pokemonmobile.UI.models

import android.app.Application
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.pokemonmobile.NavController
import com.example.pokemonmobile.PokemonApplication
import com.example.pokemonmobile.R
import com.example.pokemonmobile.UI.screen.AboutScreen
import com.example.pokemonmobile.UI.screen.ChangeStateFragmentDialog
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

class MainScreenViewModel(application: Application):AndroidViewModel(application  ) {
    private val repository by lazy { (application as PokemonApplication).repository }
    private val _stateMainScreen = MutableStateFlow(MainScreenState())
    val stateMainScreen = _stateMainScreen.asStateFlow()
    private var _fragmentManager:FragmentManager? = null
private val _stateAboutScreen = MutableStateFlow(AboutScreenState())
    val stateAboutScreen = _stateAboutScreen.asStateFlow()

    fun selectPokemon(color:Int,pokemonResponse: PokemonResponse){
        _stateAboutScreen.update {it.copy(color, pokemonResponse)  }
    }
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
    fun setFragmentManager(fragmentManager: FragmentManager){
        _fragmentManager = fragmentManager
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
    fun navigateToAboutScreen(){
        _fragmentManager?.commit {
            replace<AboutScreen>(R.id.host_fragment)
                    }
    }
    fun showStateChangeDialog(childFragmentManager:FragmentManager){
        val dialog = ChangeStateFragmentDialog()
       dialog.show(childFragmentManager,"StateChangeDialog")
    }

}

