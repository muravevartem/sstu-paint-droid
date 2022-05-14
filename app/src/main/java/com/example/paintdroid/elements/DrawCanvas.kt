package com.example.paintdroid

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import com.example.paintdroid.entities.Figure
import com.example.paintdroid.entities.FigureType

@Composable
fun DrawCanvas(color: Color, currentFigure: FigureType, figures: MutableList<Figure>) {


    val ACTION_IDLE = 0
    val ACTION_DOWN = 1
    val ACTION_MOVE = 2
    val ACTION_UP = 3

    var motionEvent by remember { mutableStateOf(ACTION_IDLE) }
    val currentPosition = remember {
        mutableStateListOf<Offset>()
    }

    val drawModifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .clipToBounds()
        .pointerInput(Unit) {
            forEachGesture {
                awaitPointerEventScope {
                    val down: PointerInputChange = awaitFirstDown().also {
                        motionEvent = ACTION_DOWN
                        currentPosition.add(it.position)
                        println(currentPosition)
                    }
                }
            }
        }






    Canvas(
        modifier = drawModifier,
    ) {


        if (currentPosition.size >= 2) {
            val p1 = currentPosition.removeFirst()
            val p2 = currentPosition.removeFirst()
            figures.add(Figure.getInstance(currentFigure, color, 7, p1, p2))
            println(figures.forEach{ println(it)})
        }

        figures.forEach {
            when (it.figureType) {
                FigureType.LINE -> {
                    drawLine(
                        color = it.color,
                        start = it.start,
                        end = it.end,
                        strokeWidth = it.lineWeight.toFloat()
                    )
                }

                FigureType.RECTANGLE -> {
                    drawRect(
                        color = it.color,
                        topLeft = it.start,
                        size = Size(it.end.x - it.start.x, it.end.y - it.start.y),
                    )
                }
                else -> Unit
            }
        }
    }
}