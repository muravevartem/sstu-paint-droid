package com.example.paintdroid.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.paintdroid.R
import com.example.paintdroid.entities.FigureType

@Composable
fun FigureBar(selected: FigureType, onChange: (FigureType)->Unit) {



    Surface(
        color = MaterialTheme.colors.primary
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 5.dp)
                .background(color = Color.Transparent),
            horizontalArrangement = Arrangement.Center,
        ) {
            IconButton(
                onClick = {
                    onChange(FigureType.LINE)
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_iconmonstr_line_one_horizontal_lined),
                    contentDescription = "circle",
                    modifier = Modifier.size(48.dp),
                    tint = (
                            if (selected == FigureType.LINE)
                                Color.White
                            else
                                Color.White.copy(0.8f)
                            )
                )
            }
            Divider(
                modifier = Modifier.size(10.dp, 0.dp)
            )
            IconButton(
                onClick = {
                    onChange(FigureType.RECTANGLE)
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_iconmonstr_square_4),
                    contentDescription = "circle",
                    modifier = Modifier.size(48.dp),
                    tint = (
                            if (selected == FigureType.RECTANGLE)
                                Color.White
                            else
                                Color.White.copy(0.4f)
                            )
                )
            }
            Divider(
                modifier = Modifier.size(10.dp, 0.dp)
            )
            IconButton(onClick = { onChange(FigureType.CIRCLE) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_iconmonstr_circle_2),
                    contentDescription = "circle",
                    modifier = Modifier.size(48.dp),
                    tint = (
                            if (selected == FigureType.CIRCLE)
                                Color.White
                            else
                                Color.White.copy(0.4f)
                            )
                )
            }
        }
    }

}