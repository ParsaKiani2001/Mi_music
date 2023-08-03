package com.example.simplemusic.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.simplemusic.view.bottomNavigation
import com.example.simplemusic.view.search

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun mainPage(){
    var select  by remember { mutableStateOf(0) }

    Scaffold(Modifier.fillMaxSize(), topBar = {search()} , bottomBar = { bottomNavigation(select = select) { select = it } })
    {
        when(select){
            0 ->{
                music()
            }
            1->{
                watch()
            }
        }
    }
}