package com.example.simplemusic.page

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplemusic.view.AllList
import com.example.simplemusic.view.playlists

@Composable
fun music(){
    val scroll = rememberScrollState()
    Column(modifier = Modifier
        .padding(10.dp, 45.dp)
        .verticalScroll(scroll)) {
        Column(modifier = Modifier.fillMaxWidth().height(840.dp)) {
            playlists {

            }
            Spacer(Modifier.height(20.dp))
            AllList()
        }
    }
}