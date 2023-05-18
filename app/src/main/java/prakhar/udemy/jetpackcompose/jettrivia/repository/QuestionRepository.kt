package prakhar.udemy.jetpackcompose.jettrivia.repository

import prakhar.udemy.jetpackcompose.jettrivia.data.DataOrException
import prakhar.udemy.jetpackcompose.jettrivia.model.QuestionItem
import prakhar.udemy.jetpackcompose.jettrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi
) {
    private val listOfQuestions =
        DataOrException<ArrayList<QuestionItem>,
                Boolean,
                Exception>()
}