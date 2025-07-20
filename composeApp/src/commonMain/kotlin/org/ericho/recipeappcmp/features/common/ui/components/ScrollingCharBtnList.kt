package org.ericho.recipeappcmp.features.common.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.ericho.recipeappcmp.features.designSystem.theme.RecipeAppCMPTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.collections.chunked
import kotlin.collections.forEach

@Composable
fun ScrollingCharBtnList(
    charList: List<Char>,
    modifier: Modifier,
    isEnable: (Char) -> Boolean = { true },
    onClick: (Char) -> Unit = {}
) {
    val letters = charList.map { it.toString() }

    LazyColumn(modifier){
        items(letters.chunked(2)) { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { letter ->
                    KeypadButton(
                        text = letter,
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth(0.5f)
                    ) {
                        if (isEnable(letter.first())) {
                            onClick(letter.first())
                        }
                    }
                }

            }
        }

    }

}

@Preview
@Composable
fun ScrollingCharBtnListPreview() {
    RecipeAppCMPTheme {
        ScrollingCharBtnList(
            charList = ('A'..'Z').toList(),
            modifier = Modifier.fillMaxWidth(0.4f),
            isEnable = { true },
            onClick = {}
        )
    }
}