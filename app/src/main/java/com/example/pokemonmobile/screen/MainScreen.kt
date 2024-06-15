package com.example.pokemonmobile.screen

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pokemonmobile.R


class MainScreen : Fragment(R.layout.fragment_main_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val changeModeButton = view.findViewById<ImageButton>(R.id.changeMode)
        val dialog = ChangeStateFragmentDialog()
        val checkedChangeListener = RadioGroup.OnCheckedChangeListener{
            group: RadioGroup?, checkedId: Int ->
           when(checkedId){
           R.id.NameCheck -> {
               setSortByName(view)

           }

            R.id.NumberCheck -> {
               setSortByNumber(view)

            }
           }
            dialog.dismiss()
        }
        dialog.setonCheckedChangeListener(checkedChangeListener)
            changeModeButton.setOnClickListener {
                dialog.show(
                    parentFragmentManager,
                    "ChangeStateDialog"
        )
    }
    }
    fun setSortByName(view: View){
        val imageButton = view.findViewById<ImageButton>(R.id.changeMode)
        imageButton.setImageResource(R.drawable.ic_sort_by_name)
    }
    fun setSortByNumber(view: View){
        val imageButton = view.findViewById<ImageButton>(R.id.changeMode)
        imageButton.setImageResource(R.drawable.vector)
    }
}

