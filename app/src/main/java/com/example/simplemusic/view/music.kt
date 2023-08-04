package com.example.simplemusic.view

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplemusic.R
import com.example.simplemusic.ui.theme.Typography
import com.example.simplemusic.ui.theme.green1
import com.example.simplemusic.ui.theme.green2
import com.example.simplemusic.ui.theme.magenta1
import com.example.simplemusic.ui.theme.magenta2
import com.example.simplemusic.ui.theme.orange1
import com.example.simplemusic.ui.theme.orange2
import com.example.simplemusic.ui.theme.whiteEF

@Composable
fun playlists(lists:List<String> = listOf("u","i"), Click: () -> Unit){
    val scroll = rememberScrollState()
    Row(horizontalArrangement =  Arrangement.Start, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .fillMaxWidth()
        .height(125.dp)
        .horizontalScroll(scroll)) {
        Spacer(modifier = Modifier.width(2.dp))
        musicCard(Color = Brush.linearGradient(colors = listOf(magenta1, magenta2),start= Offset(0f,150f),end= Offset(100f,0f)), Click = { /*TODO*/ }, icon = painterResource(id = R.drawable.favorit), name = "Favorite")
        Spacer(modifier = Modifier.width(5.dp))
        musicCard(Color = Brush.linearGradient(colors = listOf(green1, green2),start= Offset(0f,150f),end= Offset(100f,0f)), Click = { /*TODO*/ }, icon = painterResource(id = R.drawable.recent3), name = "Recent")
        lists.forEach {
            Spacer(modifier = Modifier.width(5.dp))
            musicCard(Color = Brush.linearGradient(colors = listOf(orange1, orange2),start= Offset(0f,150f),end= Offset(100f,0f)), Click = { /*TODO*/ }, icon = painterResource(id = R.drawable.playlist3), name = "$it")
        }
        Spacer(modifier = Modifier.width(2.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun musicCard(Color:Brush,Click: () -> Unit,icon:Painter,name:String){
    Card(onClick = {Click()},
        Modifier
            .background(Color, RoundedCornerShape(10.dp))
            .width(120.dp)
            .height(90.dp),colors = CardDefaults.cardColors()) {
        Box(modifier = Modifier.fillMaxSize().background(Color,RoundedCornerShape(10.dp))){
            Column (Modifier.padding(10.dp,0.dp)){
                Spacer(modifier = Modifier.height(35.dp))
                Icon(painter = icon, contentDescription = "$name", modifier = Modifier.size(20.dp), tint = whiteEF)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = name, style = Typography.labelLarge, fontWeight = FontWeight(600), fontSize = 12.sp)
            }
        }

    }
}