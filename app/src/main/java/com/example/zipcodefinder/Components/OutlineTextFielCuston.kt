package com.example.zipcodefinder.Components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.zipcodefinder.ui.theme.Green

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlineTextFielCuston(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier
) {


    OutlinedTextField(

        value,
        onValueChange,
        label = label,
        keyboardOptions = keyboardOptions,
        modifier = modifier,

        colors = TextFieldDefaults.outlinedTextFieldColors(

            cursorColor = Green,
            focusedBorderColor = Green,
            focusedLabelColor = Green,


            ),
        textStyle = TextStyle(fontSize = 18.sp),
        maxLines = 1,
        singleLine = true
    )


}