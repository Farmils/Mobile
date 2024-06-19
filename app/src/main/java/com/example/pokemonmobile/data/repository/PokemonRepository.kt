package com.example.pokemonmobile.data.repository

import com.example.pokemonmobile.data.model.PokemonItemsResponse
import com.example.pokemonmobile.data.model.PokemonResponse
import com.example.pokemonmobile.data.network.PokemonServiceImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class PokemonRepository(val pokemonServiceImpl: PokemonServiceImpl) {
    fun getPokemons():Flow<List<PokemonResponse>> = flow{
        val result = pokemonServiceImpl.getPokemons()
        val pokemonList = mutableListOf<PokemonResponse>()
        if (result.isSuccessful){
            val pokemonItems = checkNotNull(result.body())
            pokemonItems.results.forEach{
                val pokemonResponse =pokemonServiceImpl.getPokemon(it.name)
                if (pokemonResponse.isSuccessful){
                    val pokemon = checkNotNull(pokemonResponse.body())
                    pokemonList.add(pokemon)
                }
            }

        }
        emit(pokemonList)
    }
}