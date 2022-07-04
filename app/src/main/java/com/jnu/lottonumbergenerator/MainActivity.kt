package com.jnu.lottonumbergenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jnu.lottonumbergenerator.ui.theme.LottoNumberGeneratorTheme
import kotlin.random.Random

//fun main() {
//    val lottoNumberRange = (1..45)
//
//    println(lottoNumberRange.random())
//
//}

fun Color.Companion.random() : Color{
    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)

    return Color(red,green,blue)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoNumberGeneratorTheme {

                // 데이터
                // 상수
                val btnTitle = "로또번호 생성"

                // 번호 생성 횟수
                                                // 변한다
                var number01 by remember { mutableStateOf(0)}
                var number02 by remember { mutableStateOf(0)}
                var number03 by remember { mutableStateOf(0)}
                var number04 by remember { mutableStateOf(0)}
                var number05 by remember { mutableStateOf(0)}
                var number06 by remember { mutableStateOf(0)}
                var number07 by remember { mutableStateOf(0)}

                var generatedCount by remember { mutableStateOf(0)}

                // 1 ~ 45
                val lottoNumberRange = (1..45)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // 세로 로 만들때
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(
                            Modifier.fillMaxWidth()
                                .padding(all = 10.dp)
                                .padding(vertical = 40.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            LottoBall(number01)
                            LottoBall(number02)
                            LottoBall(number03)
                            LottoBall(number04)
                            LottoBall(number05)
                            LottoBall(number06)
                            LottoBall(number07)
                        }

                        Spacer(Modifier.height(150.dp))

                        Text("생성된 횟수 : $generatedCount", fontSize =  30.sp)

                        Spacer(Modifier.height(30.dp))

                        Button(onClick = {
                            number01 = lottoNumberRange.random()
                            number02 = lottoNumberRange.random()
                            number03 = lottoNumberRange.random()
                            number04 = lottoNumberRange.random()
                            number05 = lottoNumberRange.random()
                            number06 = lottoNumberRange.random()
                            number07 = lottoNumberRange.random()
                            generatedCount += 1
                        }) {
                            Text(btnTitle, fontSize =  30.sp)
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun LottoBall(number : Int){
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.random()),
        contentAlignment = Alignment.Center
    ){
        Text(
            number.toString(),
            fontSize = 20.sp,
            color = Color.White
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LottoNumberGeneratorTheme {
        Greeting("Android")
    }
}