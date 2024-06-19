package com.example.pokemonmobile.UI.models

import com.example.pokemonmobile.data.model.PokemonItemResponse
import com.example.pokemonmobile.data.model.PokemonResponse

data class MainScreenState(
    var isNumberSorted:Boolean= true,
    var isNameSorted:Boolean = false,
    val isLoading:Boolean = false,
    val isError:Boolean=false,
    val searchText:String = "",
    val pokemonList:List<PokemonResponse> = emptyList()
)
