package com.developer.vijay.composesample.demos

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun ItemUser(user: User, onClick: () -> Unit) {
    Card(
        onClick = {
            onClick()
        },
        elevation = 8.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(10.dp),
        ) {
            Text(
                text = user.id.toString().plus("."),
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontFamily = FontFamily.Cursive
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = user.fullName,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontFamily = FontFamily.Cursive
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun HorizontalRecyclerview() {
    LazyRow(
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(getData()) { index, user ->
            ItemUser(user = user) {

            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun VerticalRecyclerview() {
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(getData()) { index, user ->
            ItemUser(user = user) {

            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun StickyHeader() {

    val headers = listOf("A", "B", "C", "D", "E", "F", "G", "H")

    LazyColumn {
        headers.forEach { header ->
            stickyHeader {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Yellow),
                    text = "Header $header",
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontFamily = FontFamily.Cursive
                )
            }
            items(10) {
                Text(
                    text = "Header $header & Item $it",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun RecyclerViewPreview() {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        StickyHeader()
    }
}

fun getData(): List<User> {
    val userList = arrayListOf<User>()
    userList.add(User(1, "Vijay Koshti"))
    userList.add(User(2, "Dileep Patel"))
    userList.add(User(3, "Jignesh Rajora"))
    userList.add(User(4, "Anas Kadiwala"))
    userList.add(User(5, "Sambhav Patel"))
    userList.add(User(6, "Vijay Koshti"))
    userList.add(User(7, "Dileep Patel"))
    userList.add(User(8, "Jignesh Rajora"))
    userList.add(User(9, "Anas Kadiwala"))
    userList.add(User(10, "Sambhav Patel"))
    userList.add(User(11, "Vijay Koshti"))
    userList.add(User(12, "Dileep Patel"))
    userList.add(User(13, "Jignesh Rajora"))
    userList.add(User(14, "Anas Kadiwala"))
    userList.add(User(15, "Sambhav Patel"))
    userList.add(User(16, "Vijay Koshti"))
    userList.add(User(17, "Dileep Patel"))
    userList.add(User(18, "Jignesh Rajora"))
    userList.add(User(19, "Anas Kadiwala"))
    userList.add(User(20, "Sambhav Patel"))
    userList.add(User(21, "Vijay Koshti"))
    userList.add(User(22, "Dileep Patel"))
    userList.add(User(23, "Jignesh Rajora"))
    userList.add(User(24, "Anas Kadiwala"))
    userList.add(User(25, "Sambhav Patel"))
    userList.add(User(26, "Vijay Koshti"))
    userList.add(User(27, "Dileep Patel"))
    userList.add(User(28, "Jignesh Rajora"))
    userList.add(User(29, "Anas Kadiwala"))
    userList.add(User(30, "Sambhav Patel"))
    return userList
}

data class User(val id: Int, val fullName: String)