package com.example.simplemusic.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class navmodels : ViewModel(){
    var nav by mutableStateOf("main")
    var list by mutableStateOf( mutableListOf<String>("main"))
    fun navigate(name:String){
        nav = name;
        list.add(name)
    }
    fun navReplace(name:String){
        nav = name
        list.clear()
        list.add(name)
    }
    fun back(){
        if(list.size > 0) {
            nav = list[list.size - 2]
            list.removeAt(list.size - 1)
        }
    }
}