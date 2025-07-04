package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                DiceRoll()
            }
        }
    }
}

@Composable
fun DiceRoll() {
    // need to manage state to ensure the UI updates when the underlying data changes
    // remember and mutableStateOf creates a state variable that holds the rancom number
    // when you update this state variable Compose automatically recomposes the UI to reflect the new value
    var randomInt by remember { mutableStateOf(0) } //0 represents the empty dice

    Column {
        Image(
            painter = painterResource(id = diceImage(randomInt)),
            contentDescription = "Dice rolled: $randomInt",
            modifier = Modifier.size(100.dp)
        )

        Button(onClick = {
            randomInt = (1..6).random()
        }) {
            Text("Roll dice")
        }
    }
}

@Composable
fun diceImage(diceNumber: Int): Int {
    return when (diceNumber) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.empty_dice // default image for empty dice
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceRollerTheme {
        DiceRoll()
    }
}
