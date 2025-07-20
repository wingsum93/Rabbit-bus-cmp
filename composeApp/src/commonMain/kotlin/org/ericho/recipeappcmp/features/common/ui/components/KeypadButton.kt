package org.ericho.recipeappcmp.features.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun KeypadButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    pressedColor: Color = MaterialTheme.colorScheme.primaryContainer,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .padding(4.dp)

            .background(Color.White, shape = RoundedCornerShape(4.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onClick,
            modifier = modifier.size(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = contentColor,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White
            ),
            shape = RoundedCornerShape(6.dp),
            contentPadding = PaddingValues(0.dp), // 讓文字居中
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
        ) {
            Text(
                text = text,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun KeypadButtonPreview() {
    Column {
        KeypadButton(text = "A", onClick = {})
        KeypadButton(text = "\u007E", onClick = {})       // 用 Unicode escape
        KeypadButton(text = "\u223F", onClick = {})       // ∿ 正弦波
    }

}