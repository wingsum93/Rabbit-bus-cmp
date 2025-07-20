package org.ericho.recipeappcmp.features.busroute

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.ericho.recipeappcmp.features.common.ui.components.KeypadButton
import org.ericho.recipeappcmp.features.common.ui.components.ScrollingCharBtnList
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RouteListScreen(routes: List<UiRoute>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEB3B)) // Yellow background similar to app
    ) {
        // Tabs (最近搜尋, 全部, 巴士, 小巴, 輕鐵)
        TabRowSection()

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
        ) {
            items(routes) { route ->
                RouteItem(route)
                Divider(color = Color.LightGray, thickness = 1.dp)
            }
        }

        // Bottom keypad
        KeypadSection()
    }
}

@Composable
fun TabRowSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFEB3B))
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val tabs = listOf("最近搜尋", "全部", "巴士", "小巴", "輕鐵")
        tabs.forEach {
            Text(
                text = it,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun RouteItem(route: UiRoute) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = route.routeNumber,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.width(40.dp)
            )
            Column {
                Text(
                    text = "往 ${route.direction}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${route.destination}",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun KeypadSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFEB3B))
            .padding(8.dp)
    ) {
        val numbers = listOf(
            listOf("1", "2", "3"),
            listOf("4", "5", "6"),
            listOf("7", "8", "9"),
            listOf("\u007E","0","\u232B")
        )
        val letters2 = listOf('A', 'B', 'C', 'D', 'E', 'H', 'I', 'K')
        Row {
            Column(modifier = Modifier.weight(1f)) {
                numbers.forEach { row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        row.forEach { num ->
                            KeypadButton(text = num){

                            }
                        }
                    }
                }
            }
            ScrollingCharBtnList(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 4.dp),
                charList = letters2,
            ) {

            }
        }
    }
}




@Preview
@Composable
fun PreviewRouteListScreen() {
    val sampleRoutes = listOf(
        UiRoute("1", "竹園邨", "尖沙咀碼頭", "九巴"),
        UiRoute("1", "尖沙咀碼頭", "竹園邨", "九巴"),
        UiRoute("1", "中環 (港澳碼頭)", "跑馬地 (上)", "城巴"),
        UiRoute("1", "梅窩碼頭", "中環 (港澳碼頭)", "城巴")
    )
    RouteListScreen(routes = sampleRoutes)
}