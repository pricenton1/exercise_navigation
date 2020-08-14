package com.example.exercise_navigation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransactionViewModel:ViewModel() {

    val bank: MutableLiveData<String> = MutableLiveData("")
    val account:MutableLiveData<String> = MutableLiveData("")
    val amount:MutableLiveData<String> = MutableLiveData("")
    val name:MutableLiveData<String> = MutableLiveData("")

    fun setBank(newBank:String){
        bank.value = newBank
    }

    fun setAccount(newAccount:String){
        account.value = newAccount
    }

    fun setAmount(newAmount:String){
        amount.value = newAmount
    }

    fun setName(newName:String){
        name.value = newName
    }

}