package com.example.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.anmp_week1.databinding.FragmentGameBinding
import com.example.anmp_week1.databinding.FragmentMainBinding
import kotlin.random.Random

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    var score = 0
    var num1 = 0
    var num2 = 0
    var operator = randomOperator()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments!=null){
            val name = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$name's Turn"

            num1 = Random.nextInt(20)
            num2 = Random.nextInt(20)

            binding.txtAngka1.text = "$num1"
            binding.txtAngka2.text = "$num2"
            binding.txtOperasi.text = operator
        }

        binding.btnSubmit.setOnClickListener{
            //val action = GameFragmentDirections.actionMainFragment()  //MainFragmentDirections class yang otomatis dibuatkan oleh safeArgs
            //Navigation.findNavController(it).navigate(action)

            var res = when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                else -> throw IllegalArgumentException("operator")
            }
            var jawabanKita = binding.txtAnswer.text.toString()

            if (res == Integer.parseInt(jawabanKita)){
                score += 1
                num1 = Random.nextInt(20)
                num2 = Random.nextInt(20)
                binding.txtAngka1.text = "$num1"
                binding.txtAngka2.text = "$num2"
                binding.txtOperasi.text = operator
                var jawabanKita = binding.txtAnswer.text.toString()
                binding.txtAnswer.text.clear()
            }
            else {
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    fun randomOperator(): String {
        val operators = listOf("+", "-", "*")
        return operators.random()
    }
}