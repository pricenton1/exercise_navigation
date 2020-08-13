package com.example.exercise_navigation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import kotlinx.android.synthetic.main.fragment_amount_input.*

/**
 * A simple [Fragment] subclass.
 * Use the [AmountInputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AmountInputFragment : Fragment(),View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amount_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        username.text = "TO :"+arguments?.getString("USERNAME")
        button_send.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v){
            button_send -> {
                navController.navigate(R.id.action_amountInputFragment_to_confirmationFragment)
            }
        }
    }

}