package com.example.homegrowneducation.puzzle

import android.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.homegrowneducation.R

class PuzzleHardViewModel : ViewModel() {
    private lateinit var cube_operator_string: MutableList<Int>
    lateinit var cube_number: MutableList<Int>
    lateinit var cube_operator: MutableList<Int>
    lateinit var cube_result: MutableList<Int>
    lateinit var cube_blank: MutableList<Int>
    var cube_score = 0

    init {
        cube_score = 0
        setCube()
    }

    fun setCube() {
        cube_blank = mutableListOf(
            Color.WHITE,
            Color.WHITE,
            Color.WHITE,
            Color.BLACK,
            Color.BLACK,
            Color.BLACK,
            Color.BLACK,
            Color.BLACK,
            Color.BLACK
        )
        cube_blank.shuffle()

        cube_operator = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

        cube_number = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8)

        cube_result = mutableListOf(0, 1, 2, 3, 4, 5)

        cube_operator_string = mutableListOf(
            R.drawable.plus_solid,
            R.drawable.minus_solid,
            R.drawable.xmark_solid,
            R.drawable.divide_solid
        )

        for (i in 0..8) {
            cube_number[i] = (1..20).random()
        }

        for (i in 0..11) {
            cube_operator_string.shuffle()
            cube_operator[i] = cube_operator_string[0]
        }
        setAllresult()
    }
    fun correct(){
        cube_score++
    }

    fun setAllresult() {
        cube_result[0] = setResult(cube_operator[0], cube_operator[1], cube_number[0],
            cube_number[1], cube_number[2])
        cube_result[1] = setResult(cube_operator[5], cube_operator[6], cube_number[3],
            cube_number[4], cube_number[5])
        cube_result[2] = setResult(cube_operator[10], cube_operator[11], cube_number[6],
            cube_number[7], cube_number[8])
        cube_result[3] = setResult(cube_operator[2], cube_operator[7], cube_number[0],
            cube_number[3], cube_number[6])
        cube_result[4] = setResult(cube_operator[3], cube_operator[8], cube_number[1],
            cube_number[4], cube_number[7])
        cube_result[5] = setResult(cube_operator[4], cube_operator[9], cube_number[2],
            cube_number[5], cube_number[8])

    }


    private fun setResult( con1: Int, con2: Int, num1: Int, num2: Int, num3: Int): Int {
        var result = 0
        if(con1 == R.drawable.plus_solid &&
            con2 == R.drawable.plus_solid){
            result = num1 + num2 + num3
        }
        else if (con1 == R.drawable.minus_solid &&
            con2 == R.drawable.plus_solid){
            result = num1 - num2 + num3
        }
        else if (con1 == R.drawable.xmark_solid &&
            con2 == R.drawable.plus_solid){
            result = num1 * num2 + num3
        }
        else if (con1 == R.drawable.divide_solid &&
            con2 == R.drawable.plus_solid){
            result = num1 / num2 + num3
        }
        else if (con1 == R.drawable.plus_solid &&
            con2 == R.drawable.minus_solid){
            result = num1 + num2 - num3
        }
        else if (con1 == R.drawable.minus_solid &&
            con2 == R.drawable.minus_solid) {
            result = num1 - num2 - num3
        }
        else if (con1 == R.drawable.xmark_solid &&
            con2== R.drawable.minus_solid) {
            result = num1 * num2 - num3
        }
        else if (con1 == R.drawable.divide_solid &&
            con2 == R.drawable.minus_solid){
            result = num1 / num2 - num3
        }
        else if (con1 == R.drawable.plus_solid &&
            con2 == R.drawable.xmark_solid){
            result = num1 + num2 * num3
        }
        else if (con1 == R.drawable.minus_solid &&
            con2 == R.drawable.xmark_solid) {
            result = num1 - num2 * num3
        }
        else if (con1 == R.drawable.xmark_solid &&
            con2 == R.drawable.xmark_solid) {
            result = num1 * num2 * num3
        }
        else if (con1 == R.drawable.divide_solid &&
            con2 == R.drawable.xmark_solid) {
            result = num1 / num2 * num3
        }
        else if (con1 == R.drawable.plus_solid &&
            con2 == R.drawable.divide_solid){
            result = num1 + num2 / num3
        }
        else if (con1 == R.drawable.minus_solid &&
            con2 == R.drawable.divide_solid) {
            result = num1 - num2 / num3
        }
        else if (con1 == R.drawable.xmark_solid &&
            con2 == R.drawable.divide_solid) {
            result = num1 * num2 / num3
        }
        else {
            result = num1 / num2 / num3
        }

        return result
    }

}