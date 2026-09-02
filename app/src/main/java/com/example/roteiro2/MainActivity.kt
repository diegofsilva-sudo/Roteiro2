package com.example.roteiro2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.roteiro2.ui.theme.Roteiro2Theme

// Importados posteriomente

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Roteiro2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var texto by remember {mutableStateOf("")}

    // Lista de cadastro
    var lista = remember { mutableStateListOf("João", "Mariana")}

    Column(modifier = Modifier .fillMaxSize() .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Text(
        //   text = "Hello $name!",
        //   modifier = modifier
        //)

        OutlinedTextField(
            value = texto,
            onValueChange = { temporario ->
                texto = temporario
            },
            label = { Text("Nome") },
            placeholder = { Text(text = "Digite algum nome") })

        Row(
            modifier = Modifier.padding(top = 18.dp)
        ) {
            Button(onClick = {
                var textot = texto.trim()
                if(textot.isNotEmpty()) {
                    lista.add(texto)
                    texto = ""
                }
            }, modifier = Modifier.padding(end = 10.dp)) {
                Text(
                    text = "Adicionar a lista",
                )
            }
            Button(onClick = {
                if(lista.isNotEmpty()){
                    lista.removeAt(lista.size -1)
                    texto = ""
                }
            }) {
                Text(
                    text = "Remover ultimo elemento"
                )
            }
        }

        // Lista
        Card(modifier = Modifier.heightIn(max = 500.dp).fillMaxSize().padding(top = 50.dp)) {
            LazyColumn() {
                items(lista) { nome ->
                    Card(modifier = Modifier.padding(top = 10.dp)) {
                        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = nome,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 8.dp),
                            thickness = 1.dp,
                            color = Color.LightGray
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Roteiro2Theme {
        Greeting("Android")
    }
}