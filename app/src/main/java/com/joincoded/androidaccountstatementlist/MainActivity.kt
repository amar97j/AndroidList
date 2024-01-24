package com.joincoded.androidaccountstatementlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joincoded.androidaccountstatementlist.data.Account
import com.joincoded.androidaccountstatementlist.data.AccountStatement
import com.joincoded.androidaccountstatementlist.ui.theme.AndroidAccountStatementListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAccountStatementListTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}


@Composable
fun MainContent() {
    val account = Account()
    val accountStatementList = generateDummyData(account)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AccountCard(account)
        Spacer(modifier = Modifier.height(16.dp))
        AccountStatementList(accountStatementList)
    }
}

@Composable
fun AccountCard(account: Account) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Account Number: ${account.accountNumber}")
            Text("Account Holder: ${account.accountHolder}")
        }
    }
}

@Composable
fun AccountStatementList(accountStatements: List<AccountStatement>) {
    LazyColumn{
        items(accountStatements) { statement ->
            AccountStatementCard(statement)
        }
    }
}

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

@Composable
fun generateDummyData(account: Account): List<AccountStatement> {
    return listOf(
        AccountStatement(account, "2024-01-23", "Salary Deposit", 5000.0, TransactionType.DEPOSIT),
        AccountStatement(account, "2024-01-24", "Saving", -100.0, TransactionType.WITHDRAW),

    )
}

