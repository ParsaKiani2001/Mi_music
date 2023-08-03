package com.example.simplemusic.page

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplemusic.view.playlists

@Composable
fun music(){
    Column(modifier = Modifier.padding(10.dp,0.dp)) {
        Spacer(modifier = Modifier.height(30.dp))
        playlists {

        }
    }
}