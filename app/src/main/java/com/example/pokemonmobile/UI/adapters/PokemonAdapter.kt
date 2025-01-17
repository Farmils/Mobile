package com.example.pokemonmobile.UI.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokemonmobile.R
import com.example.pokemonmobile.data.model.PokemonItemResponse
import com.example.pokemonmobile.data.model.PokemonResponse

class PokemonAdapter(private val pokemons: List<PokemonResponse>,
                     private val  onClickCard:(PokemonResponse)->Unit): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    open class ViewHolder(view: View, private val  onClick: (PokemonResponse) -> Unit) : RecyclerView.ViewHolder(view) {
        val pokemonImage = view.findViewById<ImageView>(R.id.PokemonImage)
        val pokemonNumber = view.findViewById<TextView>(R.id.PokemonNumber)
        val pokemonName = view.findViewById<TextView>(R.id.PokemonName)
        val pokemonCard = view.findViewById<CardView>(R.id.PokemonCard)
        fun bind(pokemon: PokemonResponse){
            pokemonImage.load(pokemon.sprites.other.official_artwork.front_default)
            pokemonCard.setOnClickListener{
                onClick(pokemon)

            }
            pokemonNumber.text = pokemon.order.toString()
            pokemonName.text = pokemon.name.replaceFirstChar { it -> it.uppercase() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item,parent,false)
        return ViewHolder(view,onClickCard)
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons.get(position)
        holder.bind(pokemon)
    }
}