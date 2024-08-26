import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.airpollutionapplication.Screens.AirPollutionViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AirPollutionScreen()
            }
        }
    }

}

@Composable
fun AirPollutionScreen(viewModel: AirPollutionViewModel = ViewModel()) {
    var latitude by remember { mutableStateOf(0.0) }
    var longitude by remember { mutableStateOf(0.0) }
    var apiKey by remember { mutableStateOf("cf0082888f1c1024fc136ab54f900dbf") }

    // Fetch data on composition
    LaunchedEffect(Unit) {
        viewModel.fetchAirPollutionData(latitude, longitude, apiKey)
    }

    val data = viewModel.airPollutionData

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Air Pollution Data", style = MaterialTheme.typography,h6)
        Spacer(modifier = Modifier.height(16.dp))

        data?.let {
            Text(text = "AQI: ${it.list.first().main.aqi}")
            // Display other data similarly
        } ?: Text(text = "Loading...")
    }
}
@Composable
fun AirPollution(modifier: Modifier = Modifier,) {
    val button by  remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(5.dp)) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
        ) {
            Text(
                text = " Air Pollution",
                fontSize = 30.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.Cursive
            )
        }
        Button(onClick = { button }) {
            Text(text = "Button", fontSize = 20.sp)

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AirPollutionPreview() {
    AirPollution()

}
