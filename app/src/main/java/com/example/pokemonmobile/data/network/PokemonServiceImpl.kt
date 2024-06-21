package com.example.pokemonmobile.data.network

import com.example.pokemonmobile.data.model.PokemonItemsResponse
import com.example.pokemonmobile.data.model.PokemonResponse
import com.example.pokemonmobile.data.model.SpeciesPokemonResponse
import okhttp3.Response

class PokemonServiceImpl( private val pokemonApi: PokemonApi) {
    suspend fun getPokemons():retrofit2.Response<PokemonItemsResponse> =pokemonApi.getPokemons()
    suspend fun getPokemon(name:String):retrofit2.Response<PokemonResponse> = pokemonApi.getPokemon(name)
    suspend fun getSpeciesByName(name: String):retrofit2.Response<SpeciesPokemonResponse> = pokemonApi.getSpeciesByName(name)

}