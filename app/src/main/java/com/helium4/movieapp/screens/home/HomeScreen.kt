package com.helium4.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helium4.movieapp.model.Movie
import com.helium4.movieapp.model.getMovies
import com.helium4.movieapp.navigations.MovieScreens
import com.helium4.movieapp.widgets.movieRow

@Composable
fun HomeScreen(navController: NavController){

    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Blue,
            elevation = 5.dp) {

            Text(text = "Movies" , style = TextStyle(fontWeight = FontWeight.Bold))
        }
    }) {

MainContent(navController = navController)    }
}


@Composable
fun MainContent(
    navController: NavController,

    movieList :List<Movie> = getMovies()){


    Column(modifier = Modifier.padding(12.dp)) {

        LazyColumn{

            items(items =movieList){


                movieRow(movie = it){ movie ->


                    //goes to next screen onclicked
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                    Log.d("Tagerr","MainCOntent $movie")
                }
            }

        }
    }
    Text(text = "HelloN")
}



