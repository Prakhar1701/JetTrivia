package prakhar.udemy.jetpackcompose.jettrivia

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import prakhar.udemy.jetpackcompose.jettrivia.model.Question
import prakhar.udemy.jetpackcompose.jettrivia.screens.QuestionsViewModel
import prakhar.udemy.jetpackcompose.jettrivia.ui.theme.JetTriviaTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTriviaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TriviaHome()
                }
            }
        }
    }
}

@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()) {
    Questions(viewModel)
}

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true) {
        Log.d("LOADING", "Questions: Loading...")
    } else {
        Log.d("SIZE", "Questions: ${questions?.size}")
        questions?.forEach { questionItem ->
            Log.d("RESULT", "Question: ${questionItem.question}")
        }
    }
}
