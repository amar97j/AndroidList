package com.joincoded.androidaccountstatementlist.data

import com.joincoded.androidaccountstatementlist.TransactionType

data class AccountStatement(
    val account: Account,
    val date: String,
    val description: String,
    val amount: Double,
    val transactionType: TransactionType
)
{
}