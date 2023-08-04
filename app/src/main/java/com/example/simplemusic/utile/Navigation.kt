package com.example.simplemusic.utile

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simplemusic.page.Player
import com.example.simplemusic.page.mainPage
import com.example.simplemusic.viewmodels.navmodels

@Composable
fun mainNav(){
    val models :navmodels = viewModel()
    when(models.nav){
        "main"->{
            mainPage()
        }
        "player"->{
            Player()
        }
        "lists"->{

        }
        "settings"->{

        }
    }
}