package eu.tutorials.assignment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorials.assignment.ui.theme.DarkPurple
import eu.tutorials.assignment.ui.theme.LightPurple

@Composable
fun NavigationBar(navigationItems: List<String>, selectedItem: String, onItemSelected: (String) -> Unit) {
    LazyRow(
        modifier = Modifier
            .background(DarkPurple)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        items(navigationItems) { item ->
            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clickable { onItemSelected(item) },
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(
                        text = item,
                        color = if (item == selectedItem) Color.White else Color.Gray,
                        fontSize = 18.sp,
                        fontWeight = if (item == selectedItem) FontWeight.Bold else FontWeight.Normal
                    )
                    if (item == selectedItem) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(4.dp)
                                .background(LightPurple)
                        )
                    }
                }
            }
        }
    }
}
