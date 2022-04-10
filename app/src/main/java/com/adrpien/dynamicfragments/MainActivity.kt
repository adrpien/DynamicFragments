package com.adrpien.dynamicfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.adrpien.dynamicfragments.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val TRANSACTION_TAG: String = "Fragment Transaction"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rn = RandomNumberFragment()
        val fm = supportFragmentManager
        var isAdded: Boolean = false

        binding.addFragmentButton.setOnClickListener {
            // Adding Fragment
            if(!isAdded ) {
                fm.beginTransaction().add(R.id.fragmentContainerView, rn).addToBackStack(null).commit()
                Log.d(TRANSACTION_TAG, "onCreate: Dodano Fragment")
                isAdded = true
            }
        }

        binding.deleteFragmentButton.setOnClickListener {
            // Deleting Fragment
            if(fm.findFragmentById(R.id.fragmentContainerView) != null) {
                fm.beginTransaction().remove(rn).addToBackStack(null).commit()
                Log.d(TRANSACTION_TAG, "onCreate: Usunięto Fragment")
                isAdded = false
            }

        }



    }
}