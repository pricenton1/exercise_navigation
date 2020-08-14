package com.example.exercise_navigation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import com.example.exercise_navigation.view_model.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_amount_input.*

/**
 * A simple [Fragment] subclass.
 * Use the [AmountInputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AmountInputFragment : Fragment(),View.OnClickListener {

    lateinit var navController: NavController
    val transactionViewModel by activityViewModels<TransactionViewModel>()

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
//        username.text = "TO :"+arguments?.getString("USERNAME")
        button_send.setOnClickListener(this)
        transactionViewModel.name.observe(viewLifecycleOwner, Observer { showName(it) })
    }

    fun showName(name:String){
        val s = "To: $name"
        username.text = s
    }

    override fun onClick(v: View?) {
        when(v){
            button_send -> {
                transactionViewModel.setAmount(amount_transfer.text.toString())
                navController.navigate(R.id.action_amountInputFragment_to_confirmationFragment)
            }
        }
    }

}