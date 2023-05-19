package prakhar.udemy.jetpackcompose.jettrivia.component

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import prakhar.udemy.jetpackcompose.jettrivia.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
        Log.d("LOADING", "Questions: Loading...")
    } else {
        Log.d("SIZE", "Questions: ${questions?.size}")
        questions?.forEach { questionItem ->
            Log.d("RESULT", "Question: ${questionItem.question}")
        }
    }
}
