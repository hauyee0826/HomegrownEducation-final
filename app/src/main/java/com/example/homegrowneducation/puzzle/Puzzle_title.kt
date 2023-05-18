package com.example.homegrowneducation.puzzle

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.homegrowneducation.R
import com.example.homegrowneducation.databinding.PuzzleEasyBinding
import com.example.homegrowneducation.databinding.PuzzleTitleBinding
import com.example.homegrowneducation.mathquiz.Quiz_Page

class Puzzle_title: Fragment() {

    private lateinit var binding: PuzzleTitleBinding

            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<PuzzleTitleBinding>(
            inflater, R.layout.puzzle_title, container, false
        )
       binding.puzzleBackButton.setOnClickListener{
               view : View -> view.findNavController().navigate(R.id.action_puzzle_title_to_main_page)
       }

        binding.easyPuzzleArrow.setOnClickListener{
                view : View -> view.findNavController().navigate(R.id.action_puzzle_title_to_easy_puzzle)
        }
        binding.normalPuzzleArrow.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_puzzle_title_to_normal_puzzle)
        }
        binding.hardPuzzleArrow.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_puzzle_title_to_hard_puzzle)
        }
                return binding.root
    }

}