package com.adrpien.dynamicfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.adrpien.dynamicfragments.databinding.ActivityMainBinding

/*
How to dynamically change fragment:
1. Create class inheriting class Fragment
    - implement methods
    - return binding.root in onCreateView
2. Add fragment container in activity XML
3. Add fragment to container using transaction:
    - Create your fragment class instance
    - crate supportFragmentManager
    - add/remove/replace your fragments in containers using
      beginTransaction(container id, fragment class) - FragmentManager method
    - remember use addToBackStack(null) and commit()

If you want to add static fragment:
1. Create class inheriting class Fragment
    - implement methods
    - return binding.root in onCreateView
2. Add fragment container in activity XML
    - add "name" attribute

Fragment is hosted by activity and must be stored in some type of container
( in the past f.e. Linear Layout, now FragmentContainerView)

 */


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