package com.example.exercise_navigation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.exercise_navigation.R
import com.example.exercise_navigation.view_model.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_input_recipient.*

/**
 * A simple [Fragment] subclass.
 * Use the [InputRecipientFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputRecipientFragment : Fragment(),View.OnClickListener {

    private lateinit var navController: NavController
    val transactionViewModel by activityViewModels<TransactionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        button_next.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
       when(v){
           button_next ->{
//                val bundle = bundleOf("USERNAME" to recipient_name_text.text.toString())
               transactionViewModel.setBank(dropdown_bank.selectedItem.toString())
               transactionViewModel.setAccount(recipient_account_text.text.toString())
               transactionViewModel.setName(recipient_name_text.text.toString())
               navController.navigate(R.id.action_inputRecipientFragment_to_amountInputFragment)
           }
       }
    }
}