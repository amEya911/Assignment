package eu.tutorials.assignment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.HeadsetMic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorials.assignment.ui.theme.DarkPurple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color(0xFF241F33), Color(0x267029CC))
    )

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkPurple),
        title = {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(64.dp)
                    .background(brush = gradientBrush, shape = CircleShape),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text("VR", fontSize = 14.sp, color = Color.White)
            }
        },
        actions = {
            Row {
                IconButtonWithBackground(
                    icon = Icons.Default.HeadsetMic,
                    gradientBrush = gradientBrush
                )

                IconButtonWithBackground(
                    icon = Icons.Default.Notifications,
                    gradientBrush = gradientBrush
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .size(16.dp)
                            .background(Color.Red, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("2", color = Color.White, fontSize = 10.sp)
                    }
                }
                IconButtonWithBackground(
                    icon = Icons.Default.CardGiftcard,
                    gradientBrush = gradientBrush
                )
            }
        }
    )
}

@Composable
fun IconButtonWithBackground(
    icon: ImageVector,
    gradientBrush: Brush,
    badgeContent: (@Composable BoxScope.() -> Unit)? = null
) {
    IconButton(onClick = { /*TODO*/ }) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(brush = gradientBrush, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = Color.White)
            badgeContent?.invoke(this)
        }
    }
}