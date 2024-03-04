package com.example.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.anmp_week1.databinding.FragmentGameBinding
import com.example.anmp_week1.databinding.FragmentMainBinding
import com.example.anmp_week1.databinding.FragmentResultBinding
import kotlin.random.Random

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments!=null){
            val score = ResultFragmentArgs.fromBundle(requireArguments()).totalScore
            binding.txtResult.text = "Your Score is $score"
        }

        binding.btnMain.setOnClickListener{
            val action = GameFragmentDirections.actionMainFragment()  //MainFragmentDirections class yang otomatis dibuatkan oleh safeArgs
            Navigation.findNavController(it).navigate(action)
        }
    }
}