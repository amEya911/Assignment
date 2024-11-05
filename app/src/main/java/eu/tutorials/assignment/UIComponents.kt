package eu.tutorials.assignment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Pending
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorials.assignment.ui.theme.ButtonColor
import eu.tutorials.assignment.ui.theme.DarkPurple
import eu.tutorials.assignment.ui.theme.LightPurple

@Composable
fun GoldLockerInfo() {
    Column(
        modifier = Modifier
            .background(DarkPurple)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("24K Gold in Locker", color = Color.Yellow, fontSize = 12.sp)
                Row {
                    Text("0.828gm | ", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text("₹ 1200", color = LightPurple, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.vault), contentDescription = "Locker Image", modifier = Modifier.size(100.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = ButtonColor, contentColor = Color.White),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Save Manually", fontSize = 16.sp)
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        listOf(
            "Status" to Icons.Default.ArrowDropDown,
            "Statement" to Icons.Default.Download,
            "Filters" to Icons.Default.FilterAlt
        ).forEachIndexed { index, (text, icon) ->
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (text != "Status") {
                        Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text, color = Color.White, fontSize = 12.sp)
                    } else {
                        Text(text, color = Color.White, fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                    }
                }
            }
            if (index < 2) Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun TransactionSection(title: String, transactions: List<Transaction>) {
    Column {
        Text(
            text = title,
            color = LightPurple,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 12.dp, top = 8.dp)
        )
        transactions.forEach { transaction ->
            TransactionCard(transaction)
        }
    }
}

@Composable
fun TransactionCard(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF241f33))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(48.dp).background(Color.White, CircleShape))
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(transaction.transactionType, color = Color.White, fontSize = 16.sp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = if (transaction.isCompleted) Icons.Default.CheckCircle else Icons.Default.Pending,
                            contentDescription = null,
                            modifier = Modifier.size(12.dp),
                            tint = if (transaction.isCompleted) Color.Green else Color.Yellow
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(transaction.transactionDetails, color = Color.White, fontSize = 12.sp)
                    }
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(transaction.amount, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(transaction.grams, color = Color.White, fontSize = 12.sp)
            }
        }
    }
}