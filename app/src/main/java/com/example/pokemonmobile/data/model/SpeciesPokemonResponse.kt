package com.example.pokemonmobile.data.model

import android.graphics.Color
import org.intellij.lang.annotations.Language

data class SpeciesPokemonResponse(
    val color: UrlResource,
    val flavor_text_entries:List<FlavorText>
)
data class FlavorText(
    val flavor_text: String,
    val language: UrlResource
)
