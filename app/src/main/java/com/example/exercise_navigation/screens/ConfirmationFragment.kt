package com.example.exercise_navigation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.exercise_navigation.R
import com.example.exercise_navigation.view_model.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_confirmation.*

/**
 * A simple [Fragment] subclass.
 * Use the [ConfirmationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfirmationFragment : Fragment(),View.OnClickListener {

    val transactionViewModel by activityViewModels<TransactionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        done_button.setOnClickListener(this)
        showDataTransaction()

    }

    fun showDataTransaction(){

        val name = "Sent to ${transactionViewModel.name.value}"
        val amount = "Rp. ${transactionViewModel.amount.value}"

        sent_to_recipient_name_text.text = name
        sent_to_recipient_account_text.text = transactionViewModel.account.value
        sent_to_recipient_amount_text.text = amount
        sent_to_recipient_bank_text.text = transactionViewModel.bank.value
    }

    override fun onClick(v: View?) {
        when(v){
            done_button -> activity?.finish()
        }
    }

}