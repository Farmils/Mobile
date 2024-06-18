package com.example.pokemonmobile.data.repository

import com.example.pokemonmobile.data.model.PokemonItemsResponse
import com.example.pokemonmobile.data.network.PokemonServiceImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class PokemonRepository(val pokemonServiceImpl: PokemonServiceImpl) {
    fun getPokemons():Flow<Response<PokemonItemsResponse>> = flow{
        emit(pokemonServiceImpl.getPokemons())
    }
}