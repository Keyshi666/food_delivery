package com.example.fooddelivery_texttask.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
        Categories()
        ProductList()
        TabBar()
    }
}


@Composable
fun TopBar() {
    var expanded by remember { mutableStateOf(false) }
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
        ) {
        Row(modifier = Modifier
            .height(24.dp)
            .clickable { expanded = true }) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem( onClick = {}) {
                    Text("Москва")
                }
                DropdownMenuItem( onClick = {}) {
                    Text("Омск")
                }
                DropdownMenuItem( onClick = {}) {
                    Text("Называевск")
                }
            }
            Image(
                painter = painterResource(id = R.drawable.dropdown_icon),
                contentDescription = "",
            )
        }
    }
}

@Composable
fun BannerBar() {

}

@Composable
fun Categories() {

}

@Composable
fun ProductList() {

}

@Composable
fun TabBar() {

}