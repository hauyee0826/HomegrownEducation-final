package com.example.homegrowneducation.puzzle

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.homegrowneducation.R
import com.example.homegrowneducation.databinding.PuzzleEasyBinding

class Puzzle_easy : Fragment() {

    private lateinit var binding: PuzzleEasyBinding
    private lateinit var viewModel: PuzzleEasyViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate<PuzzleEasyBinding>(
            inflater, R.layout.puzzle_easy, container, false
        )

        viewModel = ViewModelProvider(this).get(PuzzleEasyViewModel::class.java)

        val edittext1 = EditText(context)
        val edittext2 = EditText(context)
        val edittext3 = EditText(context)
        val edittext4 = EditText(context)
        val edittext5 = EditText(context)
        val edittext6 = EditText(context)
        val edittext7 = EditText(context)
        val edittext8 = EditText(context)
        val edittext9 = EditText(context)

        val alertDialogBuilder1 = AlertDialog.Builder(context)
        val alertDialogBuilder2 = AlertDialog.Builder(context)
        val alertDialogBuilder3 = AlertDialog.Builder(context)
        val alertDialogBuilder4 = AlertDialog.Builder(context)
        val alertDialogBuilder5 = AlertDialog.Builder(context)
        val alertDialogBuilder6 = AlertDialog.Builder(context)
        val alertDialogBuilder7 = AlertDialog.Builder(context)
        val alertDialogBuilder8 = AlertDialog.Builder(context)
        val alertDialogBuilder9 = AlertDialog.Builder(context)

        setDialog(alertDialogBuilder1, edittext1, binding.cube11)
        setDialog(alertDialogBuilder2, edittext2, binding.cube13)
        setDialog(alertDialogBuilder3, edittext3, binding.cube15)
        setDialog(alertDialogBuilder4, edittext4, binding.cube31)
        setDialog(alertDialogBuilder5, edittext5, binding.cube33)
        setDialog(alertDialogBuilder6, edittext6, binding.cube35)
        setDialog(alertDialogBuilder7, edittext7, binding.cube51)
        setDialog(alertDialogBuilder8, edittext8, binding.cube53)
        setDialog(alertDialogBuilder9, edittext9, binding.cube55)

        val alertDialog1 : AlertDialog = alertDialogBuilder1.create()
        val alertDialog2 : AlertDialog = alertDialogBuilder2.create()
        val alertDialog3 : AlertDialog = alertDialogBuilder3.create()
        val alertDialog4 : AlertDialog = alertDialogBuilder4.create()
        val alertDialog5 : AlertDialog = alertDialogBuilder5.create()
        val alertDialog6 : AlertDialog = alertDialogBuilder6.create()
        val alertDialog7 : AlertDialog = alertDialogBuilder7.create()
        val alertDialog8 : AlertDialog = alertDialogBuilder8.create()
        val alertDialog9 : AlertDialog = alertDialogBuilder9.create()

        setEdittext(edittext1)
        setEdittext(edittext2)
        setEdittext(edittext3)
        setEdittext(edittext4)
        setEdittext(edittext5)
        setEdittext(edittext6)
        setEdittext(edittext7)
        setEdittext(edittext8)
        setEdittext(edittext9)

        binding.rebuildButton.setOnClickListener{ buildPuzzle(edittext1,edittext2,edittext3,
            edittext4,edittext5,edittext6,edittext7,edittext8,edittext9) }
        binding.submitButton.setOnClickListener{
            congrat(edittext1,edittext2,edittext3,edittext4,edittext5,edittext6,edittext7,edittext8,edittext9)
        }

        binding.puzzleBackButton.setOnClickListener{
                view : View -> view.findNavController().navigate(R.id.action_easy_puzzle_to_puzzle_main)
        }

        binding.cube11.setOnClickListener {
            if(binding.cube11.textColors.equals(Color.RED) || binding.cube11.textColors.equals(Color.WHITE)){
                alertDialog1.show()
            }
        }

        binding.cube13.setOnClickListener {
            if(binding.cube13.textColors.equals(Color.RED) || binding.cube11.textColors.equals(Color.WHITE)) {
                alertDialog2.show()
            }
        }

        binding.cube15.setOnClickListener {
            if(binding.cube15.textColors.equals(Color.RED) || binding.cube11.textColors.equals(Color.WHITE)) {
                alertDialog3.show()
            }
        }

        binding.cube31.setOnClickListener {
            if(binding.cube31.textColors.equals(Color.RED) || binding.cube11.textColors.equals(Color.WHITE)) {
                alertDialog4.show()
            }
        }

        binding.cube33.setOnClickListener {
            if(binding.cube33.textColors.equals(Color.RED) || binding.cube11.textColors.equals(Color.WHITE)) {
                alertDialog5.show()
            }
        }

        binding.cube35.setOnClickListener {
            if(binding.cube35.textColors.equals(Color.RED) || binding.cube11.textColors.equals(Color.WHITE)) {
                alertDialog6.show()
            }
        }

        binding.cube51.setOnClickListener {
            if(binding.cube51.textColors.equals(Color.RED) || binding.cube11.textColors.equals(Color.WHITE)) {
                alertDialog7.show()
            }
        }

        binding.cube53.setOnClickListener {
            if(binding.cube53.textColors.equals(Color.RED) || binding.cube11.textColors.equals(Color.WHITE)) {
                alertDialog8.show()
            }
        }

        binding.cube55.setOnClickListener {
            if(binding.cube55.textColors.equals(Color.RED) || binding.cube11.textColors.equals(Color.WHITE)) {
                alertDialog9.show()
            }
        }

        buildPuzzle(edittext1,edittext2,edittext3,edittext4,edittext5,edittext6,edittext7,edittext8,edittext9)

        return binding.root
    }

    private fun congrat(editText1: EditText,editText2: EditText,editText3: EditText,
                        editText4: EditText,editText5: EditText,editText6: EditText,
                        editText7: EditText,editText8: EditText,editText9: EditText,){
        if (editText1.text.toString().equals(viewModel.cube_number[0].toString())) {
            viewModel.correct()
        }
        if (editText2.text.toString().equals(viewModel.cube_number[1].toString())) {
            viewModel.correct()
        }
        if (editText3.text.toString().equals(viewModel.cube_number[2].toString())) {
            viewModel.correct()
        }
        if (editText4.text.toString().equals(viewModel.cube_number[3].toString())) {
            viewModel.correct()
        }
        if (editText5.text.toString().equals(viewModel.cube_number[4].toString())) {
            viewModel.correct()
        }
        if (editText6.text.toString().equals(viewModel.cube_number[5].toString())) {
            viewModel.correct()
        }
        if (editText7.text.toString().equals(viewModel.cube_number[6].toString())) {
            viewModel.correct()
        }
        if (editText8.text.toString().equals(viewModel.cube_number[7].toString())) {
            viewModel.correct()
        }
        if (editText9.text.toString().equals(viewModel.cube_number[8].toString())) {
            viewModel.correct()
        }

         if( viewModel.cube_score == 3) {
             binding.congraText.visibility = View.VISIBLE
             Toast.makeText(activity, "Congradulation!!!", Toast.LENGTH_SHORT).show()
         }

        viewModel.cube_score = 0

    }

    private fun setEdittext( editText: EditText){
        editText.setHint("Fill in answer")
        editText.maxLines = 1
        editText.setInputType(InputType.TYPE_CLASS_NUMBER)
    }

    private fun setDialog(alertDialogBuilder: AlertDialog.Builder, editText: EditText, textView: TextView) {
        activity.let {
            alertDialogBuilder.apply {
                setTitle("Fill blank")
                setView(editText)
                setPositiveButton("SAVE TEXT",
                    DialogInterface.OnClickListener { dialog, id ->
                        textView.text = editText.text
                        textView.setTextColor(Color.RED)
                    })
                setNegativeButton("CANCEL",
                    DialogInterface.OnClickListener { dialog, id ->

                    })
            }
            alertDialogBuilder.create()
        }

    }

    private fun buildPuzzle(editText1: EditText,editText2: EditText,editText3: EditText,
                            editText4: EditText,editText5: EditText,editText6: EditText,
                            editText7: EditText,editText8: EditText,editText9: EditText) {
        binding.congraText.visibility =View.INVISIBLE
        viewModel.setCube()
        updateOperator()
        updateCubeNumber()
        updateBlank()
        updateResult()
        Log.i("cube value1", binding.cube11.text.toString())
        Log.i("cube value2", binding.cube13.text.toString())
        Log.i("cube value3", binding.cube15.text.toString())
        Log.i("cube value4", binding.cube31.text.toString())
        Log.i("cube value5", binding.cube33.text.toString())
        Log.i("cube value6", binding.cube35.text.toString())
        Log.i("cube value7", binding.cube51.text.toString())
        Log.i("cube value8", binding.cube53.text.toString())
        Log.i("cube value9", binding.cube55.text.toString())

        editText1.text = null
        editText2.text = null
        editText3.text = null
        editText4.text = null
        editText5.text = null
        editText6.text = null
        editText7.text = null
        editText8.text = null
    }

    private fun updateCubeNumber(){
        binding.cube11.text = viewModel.cube_number[0].toString()
        binding.cube13.text = viewModel.cube_number[1].toString()
        binding.cube15.text = viewModel.cube_number[2].toString()
        binding.cube31.text = viewModel.cube_number[3].toString()
        binding.cube33.text = viewModel.cube_number[4].toString()
        binding.cube35.text = viewModel.cube_number[5].toString()
        binding.cube51.text = viewModel.cube_number[6].toString()
        binding.cube53.text = viewModel.cube_number[7].toString()
        binding.cube55.text = viewModel.cube_number[8].toString()
    }

    private fun updateResult(){
        binding.cube17.text = viewModel.cube_result[0].toString()
        binding.cube37.text = viewModel.cube_result[1].toString()
        binding.cube57.text = viewModel.cube_result[2].toString()
        binding.cube71.text = viewModel.cube_result[3].toString()
        binding.cube73.text = viewModel.cube_result[4].toString()
        binding.cube75.text = viewModel.cube_result[5].toString()
    }

    private fun updateOperator(){
        binding.cube12.setImageResource(viewModel.cube_operator[0])
        binding.cube14.setImageResource(viewModel.cube_operator[1])
        binding.cube21.setImageResource(viewModel.cube_operator[2])
        binding.cube23.setImageResource(viewModel.cube_operator[3])
        binding.cube25.setImageResource(viewModel.cube_operator[4])
        binding.cube32.setImageResource(viewModel.cube_operator[5])
        binding.cube34.setImageResource(viewModel.cube_operator[6])
        binding.cube41.setImageResource(viewModel.cube_operator[7])
        binding.cube43.setImageResource(viewModel.cube_operator[8])
        binding.cube45.setImageResource(viewModel.cube_operator[9])
        binding.cube52.setImageResource(viewModel.cube_operator[10])
        binding.cube54.setImageResource(viewModel.cube_operator[11])
    }

    private fun updateBlank(){
        binding.cube11.setTextColor(viewModel.cube_blank[0])
        binding.cube13.setTextColor(viewModel.cube_blank[1])
        binding.cube15.setTextColor(viewModel.cube_blank[2])
        binding.cube31.setTextColor(viewModel.cube_blank[3])
        binding.cube33.setTextColor(viewModel.cube_blank[4])
        binding.cube35.setTextColor(viewModel.cube_blank[5])
        binding.cube51.setTextColor(viewModel.cube_blank[6])
        binding.cube53.setTextColor(viewModel.cube_blank[7])
        binding.cube55.setTextColor(viewModel.cube_blank[8])
    }

}

