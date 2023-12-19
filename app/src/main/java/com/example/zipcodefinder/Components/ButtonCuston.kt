package com.example.zipcodefinder.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Border
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.example.zipcodefinder.ui.theme.Green
import com.example.zipcodefinder.ui.theme.White

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ButtonCuston(onClick: () -> Unit, Text: String, modifier: Modifier) {

    Button(
        onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Green, contentColor = White
        ),
        modifier = modifier,
       shape = RoundedCornerShape(10)


    ) {

        androidx.compose.material3.Text(
            text = Text, fontSize = 18.sp, fontWeight = FontWeight.Bold

        )

    }


}

@Composable
@Preview
fun PreviewButton() {

    ButtonCuston(onClick = {}, "Aperte aqui!", Modifier.fillMaxWidth())


}