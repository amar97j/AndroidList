package com.joincoded.androidaccountstatementlist.composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joincoded.androidaccountstatementlist.TransactionType
import com.joincoded.androidaccountstatementlist.data.AccountStatement

@Composable
fun AccountStatementCard(accountStatement: AccountStatement) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Date: ${accountStatement.date}")
            Text("Description: ${accountStatement.description}")
            Text("Amount: ${accountStatement.amount}")
            Text("Transaction Type: ${accountStatement.transactionType.name}")
        }
    }
}
