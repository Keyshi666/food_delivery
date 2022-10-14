package com.example.fooddelivery_texttask.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery_texttask.R

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TopBar()
        BannerBar()
        Box(Modifier.size(24.dp))
        CategoriesBar()
        ProductList()
        TabBar()
    }
}


@Composable
fun TopBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(96.dp)
        .padding(start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
        ) {
            Dropdown()
            Box(
                modifier = Modifier.weight(1.0f)
            )
            Image(
                painter = painterResource(id = R.drawable.qr_code),
                contentDescription = "",
            )
    }
}

@Composable
fun Dropdown() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Москва", "Омск", "Называевск")
    var selectedIndex by remember { mutableStateOf(0) }
    Row(modifier = Modifier
        .height(24.dp)
        .clickable { expanded = true },
        verticalAlignment = Alignment.CenterVertically)
        {
            Text_roboto(items[selectedIndex])
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                DropdownMenuItem( onClick = {
                    selectedIndex = 0
                }) {
                    Text_roboto("Москва")
                }
                DropdownMenuItem( onClick = {
                    selectedIndex = 1
                }) {
                    Text_roboto("Омск")
                }
                DropdownMenuItem( onClick = {
                    selectedIndex = 2
                }) {
                    Text_roboto("Называевск")
                }
            }
            Box(modifier = Modifier.width(14.dp))
            Image(
                painter = painterResource(id = R.drawable.dropdown_icon),
                contentDescription = "",
            )
    }
}

@Composable
fun Text_roboto(
    text : String
) {
    Text(
        text = text,
        color = Color.Black,
        fontFamily = FontFamily(Font(R.font.roboto_medium)),
        fontSize = 16.sp,
    )
}

@Composable
fun Text_sfui(
    text : String,
    color : Color,
    isChosen : Boolean
) {
    Text(
        text = text,
        color = color,
        fontFamily = FontFamily(Font(R.font.sfuitext_regular)),
        fontSize = 13.sp,
        fontWeight =
        if(isChosen) FontWeight.Bold
        else FontWeight.Normal
    )
}

@Composable
fun BannerBar() {
    LazyRow() {
        item {
            Box(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "",
            )
            Box(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "",
            )
        }
    }
}

@Composable
fun CategoriesBar() {
    LazyRow() {
        item {
            CategoryBox(
                text = "Пицца",
                isChosen = true
            )
            CategoryBox(
                text = "Пицца",
                isChosen = false
            )
            CategoryBox(
                text = "Пицца",
                isChosen = false
            )
            CategoryBox(
                text = "Пицца",
                isChosen = false
            )
            CategoryBox(
                text = "Пицца",
                isChosen = false
            )
            CategoryBox(
                text = "Пицца",
                isChosen = false
            )
        }
    }
}

@Composable
fun CategoryBox(
    text : String,
    isChosen: Boolean
) {
    Row {
        Box(modifier = Modifier
            .width(16.dp))
        Box(modifier = Modifier
            .size(88.dp, 32.dp)
            .background(
                if(isChosen) Color(0x32FD3A69) else Color.White,
                RoundedCornerShape(6.dp)
            )
            .padding(end = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            if(isChosen) {
                Text_sfui(
                    text = text,
                    color = Color(0xFFFD3A69),
                    isChosen = isChosen)
            }
            else {
                Box() {
                    Text_sfui(
                        text = text,
                        color = Color(0xFFC3C4C9),
                        isChosen = isChosen)
                }
            }
        }
    }

}

@Composable
fun ProductList() {

}

@Composable
fun TabBar() {

}

