package com.l0122096.mohammadrizki.demonslayerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.l0122096.mohammadrizki.demonslayerapp.R
import com.l0122096.mohammadrizki.demonslayerapp.adapters.ListCharacterAdapter
import com.l0122096.mohammadrizki.demonslayerapp.model.Character

class SlayersFragment : Fragment() {

    private lateinit var rvChar: RecyclerView
    private val list = ArrayList<Character>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_slayer, container, false)
        rvChar = view.findViewById(R.id.rv_char1)
        rvChar.setHasFixedSize(true)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.addAll(getListChars())
        showRecyclerList()
    }

    private fun getListChars() : ArrayList<Character> {
        val dataName = resources.getStringArray(R.array.data_name_slayer)
        val dataDesc = resources.getStringArray(R.array.data_desc_slayer)
        val dataImg = resources.obtainTypedArray(R.array.data_img_slayer)
        val listChars = ArrayList<Character>()
        for (i in dataName.indices) {
            val char = Character(dataName[i], dataDesc[i], dataImg.getResourceId(i, -1))
            listChars.add(char)
        }
        return listChars
    }

    private fun showRecyclerList() {
        rvChar.layoutManager = LinearLayoutManager(requireContext())
        val listCharAdapter = ListCharacterAdapter(list)
        rvChar.adapter = listCharAdapter

        listCharAdapter.setOnItemClickCallback(object : ListCharacterAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Character) {
                val detailFragment = DetailCharacterFragment()
                val bundle = Bundle()
                bundle.putParcelable("character", data)
                detailFragment.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.flFragment, detailFragment)
                    .addToBackStack(null)
                    .commit()
            }
        })
    }

}