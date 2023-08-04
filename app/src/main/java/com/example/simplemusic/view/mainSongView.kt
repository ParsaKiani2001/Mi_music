package com.example.simplemusic.view

import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplemusic.R
import com.example.simplemusic.ui.theme.GrayDisable
import com.example.simplemusic.ui.theme.Typography
import com.example.simplemusic.ui.theme.grayE3
import com.example.simplemusic.ui.theme.magenta2
import com.example.simplemusic.ui.theme.whiteEF
import kotlinx.coroutines.launch


@Composable
fun Modifier.placeAt(
    x: Int,
    y: Int,
) = layout { measurables, constraints ->
    val placeable = measurables.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x,y)
    }
}

@Composable
fun AllList(){
    Column(modifier = Modifier.padding(5.dp,0.dp)) {
        Text(
            text = "All songs",
            style = Typography.bodyLarge,
            fontWeight = FontWeight(800),
            fontSize = 22.sp
        )
        controlSong()

    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun controlSong(){
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0)
    val widthInDp = configuration.screenWidthDp.dp
    val heightInDp = configuration.screenHeightDp.dp

    val widthInPx = with(density) { widthInDp.roundToPx() }
    val heightInPx = with(density) { heightInDp.roundToPx() }
    Log.d("VIEW","$widthInPx $heightInPx")
    val listControling = listOf("Songs","Albums","Artists","Folders")
    TabRow(selectedTabIndex = pagerState.currentPage, containerColor = colorScheme.primary, indicator = {
         tabPositions ->
            TabRowDefaults.Indicator(
                Modifier
                    .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                    .background(
                        magenta2, shape = RoundedCornerShape(10.dp)
                    )
                    .width(80.dp),
                color = magenta2,
                height = 2.dp,
            )

    }, divider = {}) {
        for (i in listControling.indices){
            Tab(selected = pagerState.currentPage == i, onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(i)
                }
            }, text = {
                if(i == pagerState.currentPage)Text(text = listControling[i], color = whiteEF)
                else Text(text = listControling[i],color =  GrayDisable)
            })

        }
    }

    HorizontalPager(pageCount = 4,state = pagerState, modifier = Modifier.fillMaxSize(),) { page ->

        when(page){
            0-> Songs()
            1-> Artists()
            2-> Album()
            3-> Folders()
        }
    }
}

@Composable
fun Songs(){
    val Scroll = rememberScrollState()
    Column {
        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier.width(500.dp)){
                IconButton(onClick = { /*TODO*/ },Modifier.width(200.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(400.dp)
                    ) {
                        Box(modifier = Modifier
                            .background(magenta2, CircleShape)
                            .size(35.dp), contentAlignment = Alignment.Center) {
                            Icon(
                                painter = painterResource(id = R.drawable.play),
                                contentDescription = ""
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Shuffle playback",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight(500), modifier = Modifier.width(200.dp)
                        )
                    }
                };Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End, modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(id = R.drawable.arage),"list", modifier = Modifier.size(20.dp), tint = GrayDisable)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(id = R.drawable.list),"list", modifier = Modifier.size(20.dp), tint = GrayDisable)
                }
            }
            }

        }
        Column(
            Modifier
                .verticalScroll(Scroll)
                .padding(0.dp, 0.dp, 0.dp, 40.dp)) {

            //val Scroll = rememberScrollState()
            Column(modifier = Modifier) {
                for (i in 0 .. 15) SongItem();
            }
        }
    }
}
@Composable
fun Artists(){
    val Scroll = rememberScrollState()
    Column {
        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier.width(500.dp)){
                IconButton(onClick = { /*TODO*/ },Modifier.width(200.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(400.dp)
                    ) {
                        Box(modifier = Modifier
                            .background(magenta2, CircleShape)
                            .size(35.dp), contentAlignment = Alignment.Center) {
                            Icon(
                                painter = painterResource(id = R.drawable.play),
                                contentDescription = ""
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Shuffle playback",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight(500), modifier = Modifier.width(200.dp)
                        )
                    }
                }
            }

        }
        Column(
            Modifier
                .verticalScroll(Scroll)
                .padding(0.dp, 0.dp, 0.dp, 40.dp)) {

            //val Scroll = rememberScrollState()
            Column(modifier = Modifier) {
                for (i in 0 .. 15) ArtistItem();
            }
        }
    }
}
@Composable
fun Album(){
    val Scroll = rememberScrollState()
    Column {
        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier.width(500.dp)){
                IconButton(onClick = { /*TODO*/ },Modifier.width(200.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(400.dp)
                    ) {
                        Box(modifier = Modifier
                            .background(magenta2, CircleShape)
                            .size(35.dp), contentAlignment = Alignment.Center) {
                            Icon(
                                painter = painterResource(id = R.drawable.play),
                                contentDescription = ""
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Shuffle playback",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight(500), modifier = Modifier.width(200.dp)
                        )
                    }
                };Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End, modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painterResource(id = R.drawable.arage),"list", modifier = Modifier.size(20.dp), tint = GrayDisable)
                }
            }
            }

        }
        Column(
            Modifier
                .verticalScroll(Scroll)
                .padding(0.dp, 0.dp, 0.dp, 40.dp)) {

            //val Scroll = rememberScrollState()
            Column(modifier = Modifier) {
                for (i in 0 .. 15) AlbumItem();
            }
        }
    }
}
@Composable
fun Folders(){
    val Scroll = rememberScrollState()
    Column {
        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)){
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier.width(500.dp)){
                IconButton(onClick = { /*TODO*/ },Modifier.width(200.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(400.dp)
                    ) {
                        Box(modifier = Modifier
                            .background(magenta2, CircleShape)
                            .size(35.dp), contentAlignment = Alignment.Center) {
                            Icon(
                                painter = painterResource(id = R.drawable.play),
                                contentDescription = ""
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Shuffle playback",
                            style = Typography.bodyLarge,
                            fontWeight = FontWeight(500), modifier = Modifier.width(200.dp)
                        )
                    }
                }
            }

        }
        Column(
            Modifier
                .verticalScroll(Scroll)
                .padding(0.dp, 0.dp, 0.dp, 40.dp)) {

            //val Scroll = rememberScrollState()
            Column(modifier = Modifier) {
                for (i in 0 .. 15) FolderItem();
            }
        }
    }

}



@Composable
fun SongItem(){
    Spacer(modifier = Modifier.height(5.dp))
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)){
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.music), contentDescription = "")
            Column(Modifier.padding(10.dp, 0.dp)) {
                Text("Name")
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxWidth(0.7f)
                    ){
                    Icon(painter = painterResource(id = R.drawable.phone), contentDescription = "", modifier = Modifier.size(16.dp), tint =  GrayDisable)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Ai | fasfa", style = Typography.titleSmall, color = GrayDisable)
                }
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(0.dp, 0.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Outlined.Share, contentDescription ="", modifier = Modifier.size(20.dp), tint = GrayDisable )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.tab), contentDescription ="" ,modifier = Modifier.size(20.dp), tint = GrayDisable)
            }

        }

    }
}

@Composable
fun ArtistItem(){
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        Modifier
            .fillMaxHeight()
            .width(50.dp)){
        if(true){
            Column (verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxHeight()){
                Text(text = "A" , style = Typography.labelMedium, color = grayE3, fontSize = 16.sp)
                Text(text = "1 song" , style = Typography.labelSmall, color = GrayDisable, fontSize = 14.sp)
            }
        }else{
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "A" , style = Typography.labelMedium, color = GrayDisable)
        }
    }

}

@Composable
fun AlbumItem(){
    Spacer(modifier = Modifier.height(5.dp))
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)){
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.music), contentDescription = "")
            Column(Modifier.padding(10.dp, 0.dp)) {
                Text("Name")
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxWidth(0.7f)
                ){
                    Text(text = "Ai | fasfa", style = Typography.titleSmall, color = GrayDisable)
                }
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp, 0.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End){
                Icon(Icons.Default.KeyboardArrowRight, contentDescription ="" )

        }

    }
}

@Composable
fun FolderItem(){
    Spacer(modifier = Modifier.height(5.dp))
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)){
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.folder), contentDescription = "", modifier = Modifier.size(50.dp,50.dp))
            Column(Modifier.padding(10.dp, 0.dp)) {
                Text("Name")
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxWidth()
                ){
                    Text(text = "3 songs | /storage/", style = Typography.titleSmall, color = GrayDisable)
                }
            }
        }
    }
}