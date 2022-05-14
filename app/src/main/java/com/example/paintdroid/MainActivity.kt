package com.example.paintdroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.paintdroid.elements.FigureBar
import com.example.paintdroid.elements.topbars.LineProps
import com.example.paintdroid.entities.Figure
import com.example.paintdroid.entities.FigureType
import com.example.paintdroid.entities.GeneralProps
import com.example.paintdroid.ui.theme.PaintDroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            PaintDroidTheme {

                var selected by remember {
                    mutableStateOf(FigureType.LINE)
                }

                var figures = remember {
                    mutableStateListOf<Figure>()
                }

                var props by remember {
                    mutableStateOf(GeneralProps.getInstance(Color.Black, 4f))
                }




                Scaffold(
                    topBar = {
                        LineProps(props = props, onChangeProps = {props = it})
                    },
                    bottomBar = {
                        FigureBar(
                            selected = selected,
                            onChange = {selected = it})
                    }
                ) {
                    Surface(modifier = Modifier.padding(it)) {
                        DrawCanvas(props.color, selected, figures)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PaintDroidTheme {
        Greeting("Android")
    }
}