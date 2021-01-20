package io.realworld.api

import io.realworld.api.models.entities.UserCreds
import io.realworld.api.models.requests.SignupRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ConduitClientTests {

    private val conduitClient = ConduitClient()

    @Test
    fun `GET articles`() {

        runBlocking{
            val articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }

    }

    @Test
    fun `GET articles by author`() {

        runBlocking{
            val articles = conduitClient.api.getArticles(
                author = "444"
            )
            assertNotNull(articles.body()?.articles)
        }

    }

    @Test
    fun `POST signup user`() {

        runBlocking {
            val userCreds = UserCreds(
                "abcd@gmail.com",
                "abcd123456",
                "abcd_123"
            )
            val userResponse = conduitClient.api.signupUser(SignupRequest(userCreds))
            assertEquals(userCreds.username,userResponse.body()?.user?.username)    //username we are passing should be equal
                                                                                    //to the response we recieve after creation
                                                                                    //of user


        }

    }

}