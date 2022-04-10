package com.adrpien.dynamicfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrpien.dynamicfragments.databinding.FragmentRandomNumberBinding
import kotlin.random.Random


class RandomNumberFragment : Fragment() {

    private var _binding: FragmentRandomNumberBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRandomNumberBinding.inflate(inflater, container, false)

        binding.getNumberButton.setOnClickListener {
            val randomNumber = Random.nextInt(100)
            binding.randomNumberTextView.text = randomNumber.toString()
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}