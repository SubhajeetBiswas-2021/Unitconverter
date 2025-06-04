package com.subhajeet.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class UnitApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitApp()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun UnitApp(modifier: Modifier = Modifier) {

    var conversionRate = mapOf(                //immutable map
        "Metre" to 1.0,
        "Centimetre" to 100.0,
        "Feet " to 3.2804,
        "Inches" to 29.3701
    )
    var fromUnit = remember{
        mutableStateOf("Metre")
    }
    var toUnit = remember {
        mutableStateOf("Centimetre")
    }
    var inputValue = remember {
        mutableStateOf("")
    }
    var outputValue = remember {
        mutableStateOf("")
    }
    var expendFrom = remember {
        mutableStateOf(false)
    }
    var expendTo = remember {
        mutableStateOf(false)
    }

    Column(modifier=Modifier.fillMaxSize()) {
        Box (contentAlignment =Alignment.Center,
            modifier = Modifier.fillMaxWidth().padding(16.dp).border(
                width = 1.dp,
                color = Color.Black,
                shape = MaterialTheme.shapes.medium
            )){
                Text(text="Unit Converter",
                    style = MaterialTheme.typography.headlineLarge)
        }

        Spacer(modifier= Modifier.padding(16.dp))

        Row(modifier=Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Box(modifier = Modifier.weight(1f).height(56.dp).clickable
            {
                expendFrom.value = true

            }){
                Text(
                    text = fromUnit.value,
                    modifier=Modifier.align(Alignment.CenterStart)
                )
                DropdownMenu(
                    expanded = expendFrom.value,
                    onDismissRequest = {expendFrom.value= false},

                ) {
                    conversionRate.keys.forEach{
                        DropdownMenuItem(
                            text = { Text(text=it) },
                            onClick = {
                                fromUnit.value = it
                                expendFrom.value = false
                            }
                        )
                }
                }
            }
        }
    }
}

