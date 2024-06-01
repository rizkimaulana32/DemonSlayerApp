package com.l0122096.mohammadrizki.demonslayerapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.l0122096.mohammadrizki.demonslayerapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shareButton.setOnClickListener {
            val name = binding.myName.text.toString()
            val nim = binding.myNim.text.toString()
            val majorClass = binding.myMajorClass.text.toString()
            val fa = binding.myFaculty.text.toString()
            val univ = binding.myUniv.text.toString()
            val email = binding.myEmail.text.toString()

            val message = "Name: $name\nNIM: $nim\nMajor and Class: $majorClass\nFaculty: $fa\nUniversity: $univ\nEmail: $email"

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, message)

            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
