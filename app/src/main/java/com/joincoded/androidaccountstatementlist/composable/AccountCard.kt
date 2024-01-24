package com.joincoded.androidaccountstatementlist.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joincoded.androidaccountstatementlist.data.Account


@Composable
fun AccountCard(account: Account) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)

        ) {
            Text("Account Number: ${account.accountNumber}")
            Text("Account Holder: ${account.accountHolder}")
        }
    }
}
