package com.example.pokemonmobile.UI.models

import android.content.res.Resources
import android.graphics.Color
import com.example.pokemonmobile.R
import com.example.pokemonmobile.data.model.PokemonResponse

data class AboutScreenState(
    var color:Int =R.color.white,
    var pokemonResponse: PokemonResponse? = null
)