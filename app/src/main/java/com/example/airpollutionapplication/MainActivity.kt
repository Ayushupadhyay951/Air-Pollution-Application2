import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.airpollutionapp.ui.screens.WeatherState
import com.example.airpollutionapplication.ui.theme.AirPollutionApplicationTheme
import com.example.airpollutionapplication.ui.theme.AirPollutionScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AirPollutionApplicationTheme {
                AirPollutionScreen(state = WeatherState())
            }
        }
    }
}
