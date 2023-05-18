package prakhar.udemy.jetpackcompose.jettrivia.network

import prakhar.udemy.jetpackcompose.jettrivia.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question
}