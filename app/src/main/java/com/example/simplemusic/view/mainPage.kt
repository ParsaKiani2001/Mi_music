package com.example.simplemusic.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplemusic.R
import com.example.simplemusic.ui.theme.GrayDisable
import com.example.simplemusic.ui.theme.IconFont
import com.example.simplemusic.ui.theme.PinkEnable
import com.example.simplemusic.ui.theme.Typography
import com.example.simplemusic.ui.theme.menuIcon
import com.example.simplemusic.ui.theme.whiteEF

@Composable
fun search(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp, 4.dp)
        .height(35.dp), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
        Spacer(modifier = Modifier.width(5.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(modifier = Modifier.size(22.dp), painter = painterResource(id = R.drawable.setting2), contentDescription = "settings")
        }
        IconButton(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(5.dp, 1.dp),onClick = { /*TODO*/ }) {
            Row (modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray, RoundedCornerShape(100)), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
                Icon(painter = painterResource(id = R.drawable.search), contentDescription ="", modifier = Modifier.padding(8.dp,0.dp) )
                Text(text = "search", modifier = Modifier.fillMaxWidth(0.8f))
                Icon(painterResource(id = R.drawable.mic), contentDescription = "", modifier = Modifier.padding(8.dp,0.dp))
                Spacer(modifier = Modifier.width(5.dp))
            }
        }

    }
}

@Composable
fun bottomNavigation(select:Int, change: (Int) -> Unit){
    var select by remember{ mutableStateOf(0) }
    Row(modifier = Modifier
        .height(68.dp)
        .fillMaxWidth()
        .padding(0.dp, 5.dp, 0.dp, 0.dp)
        .background(Color(0xFF161616)), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){
        IconButton(modifier = Modifier
            .fillMaxHeight()
            .width(100.dp),onClick = {select = 0;change(0)}) {
            Column(verticalArrangement = Arrangement.SpaceAround,horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxHeight()) {
                Spacer(modifier = Modifier.height(2.dp))
                Icon(painterResource(id = R.drawable.music2), null, tint =if(select == 0) PinkEnable else GrayDisable, modifier = Modifier.size(33.dp))
                Text("Music", color = if(select == 0) PinkEnable else GrayDisable ,style = Typography.labelMedium)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        IconButton(modifier = Modifier
            .fillMaxHeight()
            .width(100.dp),onClick = {select = 1;change(1)}) {
            Column(verticalArrangement = Arrangement.SpaceAround,horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxHeight()) {
                Spacer(modifier = Modifier.height(4.dp))
                Icon(painterResource(id = R.drawable.watch3), null, tint =if(select == 1) PinkEnable else GrayDisable, modifier = Modifier.size(33.dp))
                Text("Watch", color = if(select == 1) PinkEnable else GrayDisable,style = Typography.labelMedium)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}