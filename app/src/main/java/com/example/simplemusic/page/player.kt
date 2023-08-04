package com.example.simplemusic.page

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simplemusic.R
import com.example.simplemusic.ui.theme.BaseBlack
import com.example.simplemusic.ui.theme.magenta1
import com.example.simplemusic.ui.theme.magenta1_5
import com.example.simplemusic.ui.theme.magenta2
import com.example.simplemusic.viewmodels.navmodels

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Player(){
    val nav :navmodels = viewModel()
    val view = LocalView.current
    val window = (view.context as Activity).window
    BackHandler {
        window.statusBarColor = BaseBlack.toArgb()
        nav.back()
    }
    var lyrics by remember { mutableStateOf(false) }
    window.statusBarColor = magenta1.toArgb()
    Column(
        Modifier
            .background(magenta1)
            .fillMaxWidth()
            .fillMaxHeight()) {
        Box(modifier = Modifier
            .padding(10.dp, 0.dp)
            .fillMaxWidth()
            .height(50.dp), contentAlignment = Alignment.Center){
            Row(Modifier.fillMaxWidth()){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.KeyboardArrowDown,"")
                }
            }
            Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(id = R.drawable.tab),"", modifier = Modifier.size(20.dp))
                }
            }
            Row(
                Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight(),horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                 TabRow(modifier = Modifier
                     .padding(vertical = 4.dp, horizontal = 8.dp)
                     .clip(RoundedCornerShape(50.dp))
                     .height(30.dp)
                     , contentColor = magenta1_5, containerColor = magenta1_5,selectedTabIndex = 0, divider = {}, indicator = {
                         Box{}
                 }) {
                     Tab(modifier = if (!lyrics) Modifier
                         .clip(RoundedCornerShape(50))
                         .height(30.dp)
                         .background(
                             magenta2
                         )
                     else Modifier
                         .clip(RoundedCornerShape(50.dp))
                         .height(30.dp)
                         .background(
                             Color(
                                 magenta1_5.toArgb()
                             )
                         ),selected = false, onClick = { lyrics = false }) {
                         Text("Song")
                     }
                     Tab(modifier = if (lyrics) Modifier
                         .clip(RoundedCornerShape(50.dp))
                         .height(30.dp)
                         .background(
                             magenta2
                         )
                     else Modifier
                         .clip(RoundedCornerShape(50))
                         .height(30.dp)
                         .background(
                             Color(
                                 magenta1_5.toArgb()
                             )
                         ),selected = true, onClick = { lyrics = true }) {
                         Text("Lyrics")
                     }
                 }
            }
        }
        HorizontalPager(pageCount = 2) {

        }
    }
}

@Composable
fun song(){

}
@Composable
fun Lyrics(){

}
