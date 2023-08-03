package com.example.simplemusic.view

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplemusic.R
import com.example.simplemusic.ui.theme.Typography

@Composable
fun playlists(lists:List<String> = listOf("u","i"), Click: () -> Unit){
    val scroll = rememberScrollState()
    Row(horizontalArrangement =  Arrangement.Start, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .fillMaxWidth()
        .height(170.dp)
        .horizontalScroll(scroll)) {
        Spacer(modifier = Modifier.width(2.dp))
        musicCard(Color = Color.Cyan, Click = { /*TODO*/ }, icon = painterResource(id = R.drawable.recent2), name = "Recent")
        Spacer(modifier = Modifier.width(8.dp))
        musicCard(Color = Color.Black, Click = { /*TODO*/ }, icon = painterResource(id = R.drawable.feedback), name = "Favorit")
        lists.forEach {
            Spacer(modifier = Modifier.width(9.dp))
            musicCard(Color = Color.Magenta, Click = { /*TODO*/ }, icon = painterResource(id = R.drawable.watch3), name = "$it")
        }
        Spacer(modifier = Modifier.width(2.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun musicCard(Color:Color,Click: () -> Unit,icon:Painter,name:String){
    Card(onClick = {Click()},
        Modifier
            .background(Color, RoundedCornerShape(10.dp))
            .width(120.dp)
            .height(90.dp),colors = CardDefaults.cardColors(containerColor = Color)) {
        Column (Modifier.padding(10.dp,0.dp)){
            Spacer(modifier = Modifier.height(35.dp))
            Icon(painter = icon, contentDescription = "$name", modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = name, style = Typography.labelLarge, fontWeight = FontWeight(600), fontSize = 12.sp)
        }
    }
}