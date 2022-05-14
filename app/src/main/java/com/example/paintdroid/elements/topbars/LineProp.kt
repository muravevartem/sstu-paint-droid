package com.example.paintdroid.elements.topbars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.paintdroid.entities.GeneralProps

@Composable
fun LineProps(props: GeneralProps, onChangeProps: (GeneralProps) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Линии", color = Color.White)
                Divider(Modifier.size(10.dp, 0.dp))
                ColorPicker(color = props.color, onChange = { onChangeProps(props.setColor(it)) })
                OutlinedTextField(
                    value = props.width.toString(),
                    onValueChange = { if (it.isDigitsOnly()) { onChangeProps(props.setWidth(it.toFloat()))} },
                    Modifier.widthIn(min = 48.dp, max = 96.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            }
        }
    }
}