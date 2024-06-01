package com.l0122096.mohammadrizki.demonslayerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.l0122096.mohammadrizki.demonslayerapp.databinding.ActivityMainBinding
import com.l0122096.mohammadrizki.demonslayerapp.fragments.CharactersFragment
import com.l0122096.mohammadrizki.demonslayerapp.fragments.HomeFragment
import com.l0122096.mohammadrizki.demonslayerapp.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = HomeFragment()
        val secondFragment = CharactersFragment()
        val thirdFragment = ProfileFragment()

        setCurrentFragment(firstFragment)

        binding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> setCurrentFragment(firstFragment)
                R.id.nav_char -> setCurrentFragment(secondFragment)
                R.id.nav_profile -> setCurrentFragment(thirdFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(binding.flFragment.id,fragment)
            commit()
        }

    fun showBottomNavigation() {
        binding.bottomNavView.visibility = View.VISIBLE
    }

    fun hideBottomNavigation() {
        binding.bottomNavView.visibility = View.GONE
    }

}
