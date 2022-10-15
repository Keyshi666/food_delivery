package com.example.fooddelivery_texttask.presentation.main

import androidx.annotation.DrawableRes
import androidx.appcompat.app.ActionBar.Tab
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery_texttask.R
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState
import androidx.compose.foundation.layout.Column as Column

@Composable
fun MainScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        
        CollapsingToolbarScaffold(
            state = rememberCollapsingToolbarScaffoldState(), // provide the state of the scaffold
            toolbar = {
                Column(Modifier.weight(1.0f)){
                    TopAppBar(backgroundColor = Color.White,
                        elevation = 0.dp) {
                        Box(Modifier.size(24.dp))
                        TopBar()
                        //Box(Modifier.weight(1.0f))



                    }


                }

            },
            modifier = Modifier
                .fillMaxSize(),
            scrollStrategy = ScrollStrategy.ExitUntilCollapsed
        ) {

            Column (
                Modifier.background(Color.White)
            ) {

                CollapsingToolbarScaffold(
                    state = rememberCollapsingToolbarScaffoldState(), // provide the state of the scaffold
                    toolbar = {
                        Column() {
                            BannerBar()
                        }
                    },
                    modifier = Modifier
                        .weight(1.0f),
                    scrollStrategy = ScrollStrategy.EnterAlways
                ) {

                    Column() {
                        CategoriesBar()
                        ProductList()

                    }
                    // main contents go here...
                }
                BottomAppBar(
                    backgroundColor = Color(0xFFF0F0F0)
                ) {
                    Column(Modifier.size(360.dp, 56.dp)) {
                        Box(Modifier.size(5.dp))
                        TabBar()
                    }
                }

            }
        }


//        TopBar()
//        BannerBar()
//        Box(Modifier.size(24.dp))
//        CategoriesBar()
//        ProductList()
//        TabBar()
    }
}


@Composable
fun TopBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
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
fun Text_inter(
    text : String,
    color : Color
) {
    Text(
        text = text,
        color = color,
        fontFamily = FontFamily(Font(R.font.inter_medium)),
        fontSize = 12.sp,
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
            Box(modifier = Modifier.size(16.dp))
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "",
            )
            Box(modifier = Modifier.size(16.dp))
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
                if (isChosen) Color(0x32FD3A69) else Color.White,
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
                Text_sfui(
                    text = text,
                    color = Color(0xFFC3C4C9),
                    isChosen = isChosen)
            }
        }
    }

}

@Composable
fun ProductList() {
    LazyColumn(modifier = Modifier
        .padding(16.dp)) {
        item{
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.pizza),
                    contentDescription = "",
                )
                Box(Modifier.size(22.dp))
                Column() {
                    ProductText(
                        name = "Ветчина и грибы",
                        ingredients = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус"
                    )
                    ProductPrice(price = 345)
                }
                Box(Modifier.size(32.dp))
            }
            Box(Modifier.size(32.dp))
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.pizza),
                    contentDescription = "",
                )
                Box(Modifier.size(22.dp))
                Column() {
                    ProductText(
                        name = "Ветчина и грибы",
                        ingredients = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус")
                    ProductPrice(price = 345)
                }
            }
            Box(Modifier.size(32.dp))
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.pizza),
                    contentDescription = "",
                )
                Box(Modifier.size(22.dp))
                Column() {
                    ProductText(
                        name = "Ветчина и грибы",
                        ingredients = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус")
                    ProductPrice(price = 345)
                }
            }
        }
    }
}

@Composable
fun ProductText(
    name: String,
    ingredients: String) {
    Column() {
        Text_roboto(text = name)
        Box(Modifier.size(8.dp))
        Box(Modifier.size(171.dp,68.dp)) {
            Text_sfui(text = ingredients, color = Color(0xFFAAAAAD), isChosen = false)
        }
        Box(Modifier.size(8.dp))
    }
}

@Composable
fun ProductPrice (price: Int) {
    Box(Modifier.size(171.dp,32.dp),
    contentAlignment = Alignment.CenterEnd) {
        Box(
            Modifier
                .size(87.dp, 32.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFFD3A69),
                    shape = RoundedCornerShape(6.dp),
                ),
            contentAlignment = Alignment.Center) {
            Text_sfui(text = "от $price р", color = Color(0xFFFD3A69), isChosen = false)
        }
    }

}

@Composable
fun TabBar() {
    Row(Modifier.size(360.dp, 56.dp)) {
        Tab(
            icon = R.drawable.menu_icon,
            textColor = Color(0xFFFD3A69),
            text = "Меню"
        )
        Tab(
            icon = R.drawable.profile_icon,
            textColor = Color(0xFF7B7B7B),
            text = "Профиль"
        )
        Tab(
            icon = R.drawable.garbage_icon,
            textColor = Color(0xFF7B7B7B),
            text = "Корзина"
        )
    }
}

@Composable
fun Tab (
    @DrawableRes icon: Int,
    textColor: Color,
    text: String
) {
    Column(Modifier
        .size(120.dp, 56.dp),
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
        )
        Box(Modifier.size(3.dp))
        Text_inter(text = text, color = textColor)
    }
}

