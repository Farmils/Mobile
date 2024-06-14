package com.example.pokemonmobile.screen

import android.os.Bundle
import android.view.Gravity
import android.view.MenuInflater
import android.view.View
import android.widget.ImageButton
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.example.pokemonmobile.R


class MainScreen : Fragment(R.layout.fragment_main_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val changeMode = view.findViewById<ImageButton>(R.id.changeMode)
        changeMode.setOnClickListener{
            val menu = PopupMenu(requireContext(),it, )
            val inflater: MenuInflater = menu.menuInflater
            inflater.inflate(R.menu.search_menu,menu.menu)
            menu.show()
        }
    }

}