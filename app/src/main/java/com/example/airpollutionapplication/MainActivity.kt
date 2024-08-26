import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    var apiKey by remember { mutableStateOf("YOUR_API_KEY") }

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

