package com.l0122096.mohammadrizki.demonslayerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.l0122096.mohammadrizki.demonslayerapp.databinding.FragmentDetailCharacterBinding
import com.l0122096.mohammadrizki.demonslayerapp.model.Character
import com.l0122096.mohammadrizki.demonslayerapp.MainActivity


class DetailCharacterFragment : Fragment() {

    private var _binding: FragmentDetailCharacterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailCharacterBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val character = arguments?.getParcelable<Character>("character")

        if (character != null) {
            displayCharacterDetails(character)
        }

        hide(requireActivity() as MainActivity)

        return rootView
    }

    private fun hide (activity: MainActivity){
        activity.hideBottomNavigation()
    }

    private fun show (activity: MainActivity){
        activity.showBottomNavigation()
    }

    override fun onStop() {
        super.onStop()
        show(requireActivity() as MainActivity)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun displayCharacterDetails(character: Character) {
        binding.tvName.text = character.name
        binding.tvDescription.text = character.description
        binding.imgCharacter.setImageResource(character.img)
    }
}
