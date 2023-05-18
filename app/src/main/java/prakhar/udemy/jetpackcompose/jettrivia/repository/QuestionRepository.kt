package prakhar.udemy.jetpackcompose.jettrivia.repository

import android.util.Log
import prakhar.udemy.jetpackcompose.jettrivia.data.DataOrException
import prakhar.udemy.jetpackcompose.jettrivia.model.QuestionItem
import prakhar.udemy.jetpackcompose.jettrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi
) {
    private val dataOrException =
        DataOrException<ArrayList<QuestionItem>,
                Boolean,
                Exception>()

    suspend fun getAllQuestion(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {

        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("Exc", "getAllQuestion: ${dataOrException.e!!.localizedMessage}")
        }

        return dataOrException
    }

}