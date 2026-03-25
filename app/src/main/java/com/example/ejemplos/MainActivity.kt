package com.example.ejemplos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.rotate
import com.example.ejemplos.ui.theme.EjemplosTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemplosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Greeting(name = "Android")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

// --- EJEMPLOS DE LAYOUT ---

@Preview(showBackground = true)
@Composable
fun WidthExample() {
    Column(Modifier.width(300.dp)) {
        Text(
            text = "width() -> 100dp",
            modifier = Modifier.width(100.dp).height(100.dp).background(Color.Yellow)
        )
        Text(
            text = "fillMaxWidth()",
            modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Blue)
        )
        Text(
            text = "requiredWidth()",
            modifier = Modifier.requiredWidth(400.dp).height(100.dp).background(Color.Red)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HeightExamples() {
    Row(Modifier.height(300.dp)) {
        Text("100dp", Modifier.weight(1f).height(100.dp).background(Color.Yellow))
        Text("MAX", Modifier.weight(1f).fillMaxHeight().background(Color.Blue))
        Text("MAX/2", Modifier.weight(1f).fillMaxHeight(0.5f).background(Color.Red))
        Text("400dp", Modifier.weight(1f).requiredHeight(400.dp).background(Color.Green))
    }
}

@Composable
@Preview(showBackground = true)
fun SizeExamples() {
    Box(Modifier.size(300.dp)) {
        Box(Modifier.fillMaxSize().background(Color.Yellow))
        Box(Modifier.size(50.dp).align(Alignment.BottomCenter).background(Color.Blue))
        Box(Modifier.size(50.dp, 100.dp).background(Color.Red))
        Box(Modifier.requiredSize(100.dp).align(Alignment.CenterEnd).background(Color.Green))
    }
}

@Composable
@Preview(showBackground = true)
fun OffsetExample() {
    Box(Modifier.size(100.dp).offset(10.dp, 15.dp).background(Color.Blue))
}

@Composable
@Preview(showBackground = true)
fun BorderExamples() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Box(Modifier.size(100.dp).border(3.dp, Color.DarkGray))
        Box(Modifier.size(100.dp).border(BorderStroke(3.dp, Color.Green), CutCornerShape(5.dp)))
        Box(Modifier.size(100.dp).border(
            width = 3.dp,
            brush = Brush.horizontalGradient(listOf(Color.Yellow, Color.Blue, Color.Red)),
            shape = RectangleShape
        ))
    }
}

@Composable
@Preview(showBackground = true)
fun PaddingExamples() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Box(Modifier.background(Color.Blue)) {
            Text("Top/Start 32dp", Modifier.padding(top = 32.dp, start = 32.dp).background(Color.Yellow))
        }
        Box(Modifier.background(Color.Blue)) {
            Text("Horizontal 32dp", Modifier.padding(horizontal = 32.dp).background(Color.Yellow))
        }
        Box(Modifier.background(Color.Blue)) {
            Text("All 32dp", Modifier.padding(32.dp).background(Color.Yellow))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AlphaExample() {
    Box(Modifier.size(150.dp, 100.dp)) {
        Box(Modifier.size(100.dp).alpha(0.5f).background(Color.Blue, CircleShape).border(2.dp, Color.Blue, CircleShape))
        Box(Modifier.size(100.dp).alpha(0.5f).background(Color.Red, CircleShape).border(2.dp, Color.Red, CircleShape).align(Alignment.CenterEnd))
    }
}

// --- GRADIENTES ---
val globalBrush = Brush.horizontalGradient(listOf(Color.Green, Color.Red))

@Composable
@Preview(showBackground = true)
fun BackgroundExample() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Box(Modifier.size(100.dp).background(Color.Yellow))
        Box(Modifier.size(100.dp).background(brush = globalBrush))
    }
}

@Composable
@Preview(showBackground = true)
fun ClipExample() {
    Row(Modifier.padding(16.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(Modifier.size(100.dp).clip(CircleShape).background(Color.Blue))
            Box(Modifier.size(100.dp, 50.dp).clip(RoundedCornerShape(50)).background(Color.Blue))
            Box(Modifier.size(100.dp).clip(RoundedCornerShape(topStart = 50.dp)).background(Color.Blue))
        }
        Spacer(Modifier.size(8.dp))
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(Modifier.size(100.dp).clip(RectangleShape).background(Color.Blue))
            Box(Modifier.size(100.dp).clip(CutCornerShape(50)).background(Color.Blue))
            Box(Modifier.size(100.dp).clip(CutCornerShape(topEnd = 25.dp)).background(Color.Blue))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScaleExample() {
    Row(
        Modifier.fillMaxWidth().height(200.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(Modifier.scale(0.5f).size(100.dp).background(Color.Yellow))
        Box(Modifier.scale(1f).size(100.dp).background(Color.Blue))
        Box(Modifier.scale(2f).size(100.dp).background(Color.Red))
    }
}
@Composable
@Preview
fun RotateExample() {
    Row(modifier = Modifier.padding(16.dp)) {
        RotableCircle(0f)
        RotableCircle(45f)
        RotableCircle(90f)
        RotableCircle(135f)
    }
}
@Composable
fun RotableCircle(degrees: Float) {
    Box(
        Modifier

            .rotate(degrees)
            .size(50.dp)
            .background(Color.Yellow, CircleShape)

    ) {
        Box(

            Modifier

                .size(15.dp)
                .background(Color.Blue, CircleShape)
                .align(Alignment.TopCenter)

        )
    }
}
@Composable
@Preview
fun ChainingExample() {
    Box(
        Modifier

            .border(2.dp, Color.Red)
            .background(Color.Blue)
            .padding(16.dp)
            .background(Color.Yellow)
            .size(100.dp)

    )
}
@Composable
@Preview
fun ChainingExample2() {
    Row {
        Box(

            Modifier

                .border(2.dp, Color.Red)
                .background(Color.Blue)
                .padding(16.dp)
                .background(Color.Yellow)
                .size(100.dp)

        )
        Box(

            Modifier
                .size(100.dp)
                .background(Color.Yellow)
                .border(2.dp, Color.Red)
                .padding(16.dp)
                .background(Color.Blue)

        )
    }
}
