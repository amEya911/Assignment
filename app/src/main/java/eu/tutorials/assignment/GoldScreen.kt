package eu.tutorials.assignment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
@Composable
fun GoldScreen() {
    var selectedItem by remember { mutableStateOf("Gold") }
    val navigationItems = listOf("Gold", "Mar UPI", "Nek", "Loan")

    Scaffold(
        topBar = {
            AppBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavigationBar(navigationItems, selectedItem) { selectedItem = it }
            GoldLockerInfo()
            ActionButtons()

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item { TransactionSection("Today", transactionsToday) }
                item { TransactionSection("Yesterday", transactionsYesterday) }
                item { TransactionSection("4 Oct 2024", transactions4Oct) }
            }
        }
    }
}