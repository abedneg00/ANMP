package com.example.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.anmp_week1.databinding.ActivityMainBinding
import com.example.anmp_week1.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //untuk mengakses UI-UI yang ada
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart.setOnClickListener{
            //cara mengeksekusi action nya yang ada di game_navigation

            //setelah kita tambahkan attribut argumen di gameFragment, maka kurung tutup nya harus ada variabel
            val name = binding.txtName.text.toString()
            val action = MainFragmentDirections.actionGameFragment(name)  //MainFragmentDirections class yang otomatis dibuatkan oleh safeArgs
            Navigation.findNavController(it).navigate(action)
        }
    }
}