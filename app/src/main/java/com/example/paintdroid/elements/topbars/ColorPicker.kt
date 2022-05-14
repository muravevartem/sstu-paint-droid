package com.example.paintdroid.elements.topbars

import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColorPicker(color: Color, onChange: (Color) -> Unit) {

    var openDialog by remember {
        mutableStateOf(false)
    }

    val colors =
        listOf(Color.Black, Color.Blue, Color.Red, Color.Yellow, Color.Magenta, Color.Green)

    if (openDialog)
        Dialog(onDismissRequest = { openDialog = false }) {
            val scroll = rememberScrollState()
            Column(
                modifier = Modifier.verticalScroll(scroll)
            ) {
                colors.forEach {
                    Divider(modifier = Modifier.height(5.dp), color = Color.Transparent)
                    Surface(
                        color = it,
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp)),
                        onClick = { openDialog = false; onChange(it) },
                    ) {

                    }
                    Divider(modifier = Modifier.height(5.dp), color = Color.Transparent)
                }
            }
        }

    Surface(
        modifier = Modifier.clip(RoundedCornerShape(25))
    ) {
        Surface(
            color = color,
            modifier = Modifier.size(48.dp),
            onClick = { openDialog = true },
        ) {

        }
    }
}