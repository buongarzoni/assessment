package scoring

import common.randomString
import org.buongarzoni.scoring.Accuracy
import org.buongarzoni.scoring.CalculateScoring
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class CalculateScoringTest {
    //private val calculateScoring = CalculateScoring()
    private val calculateScoring = CalculateScoringJava()

    @Test
    fun `Must return HIGH Accuracy when 2 users have the same Id`() {
        val id = 1
        val user = userRandom(id = id)
        val anotherUser = userRandom(id = id)

        val accuracy = calculateScoring.execute(user, anotherUser)

        assertEquals(Accuracy.HIGH, accuracy)
    }

    @Test
    fun `Must return HIGH Accuracy when 2 users have the same email`() {
        val matchingEmail = "some@email.com"
        val user = userRandom(email = matchingEmail)
        val anotherUser = userRandom(email = matchingEmail)

        val accuracy = calculateScoring.execute(user, anotherUser)

        assertEquals(Accuracy.HIGH, accuracy)
    }

    @Test
    fun `Must return HIGH Accuracy when 2 users have similar email name but different provider, and name and last name are similar in both users, and have same zip code`() {
        val emailGmail = "some@gmail.com"
        val emailHotmail = "some@hotmail.com"
        val zipCode = 12
        val user = userRandom(name = "Juan", lastName = "Perez", email = emailGmail, zipCode = zipCode)
        val anotherUser = userRandom(name = "J", lastName = "P", email = emailHotmail, zipCode = zipCode)

        val accuracy = calculateScoring.execute(user, anotherUser)

        assertEquals(Accuracy.HIGH, accuracy)
    }

    @Test
    fun `Must return HIGH Accuracy when 2 users have similar email name but different provider, and name and last name are similar in both users, and have same address`() {
        val emailGmail = "some@gmail.com"
        val emailHotmail = "some@hotmail.com"
        val address = randomString()
        val user = userRandom(name = "Juan", lastName = "Perez", email = emailGmail, address = address)
        val anotherUser = userRandom(name = "J", lastName = "P", email = emailHotmail, address = address)

        val accuracy = calculateScoring.execute(user, anotherUser)

        assertEquals(Accuracy.HIGH, accuracy)
    }

    @Test
    fun `Must return MEDIUM Accuracy when 2 users have similar name and last name, and similar address`() {
        val address = randomString()
        val user = userRandom(name = "Juan", lastName = "Perez", address = address)
        val anotherUser = userRandom(name = "J", lastName = "P", address = address)

        val accuracy = calculateScoring.execute(user, anotherUser)

        assertEquals(Accuracy.MEDIUM, accuracy)
    }

    @Test
    fun `Must return MEDIUM Accuracy when 2 users have similar name and last name, and same zip code`() {
        val address = randomString()
        val user = userRandom(name = "Juan", lastName = "Perez", address = address)
        val anotherUser = userRandom(name = "J", lastName = "P", address = address)

        val accuracy = calculateScoring.execute(user, anotherUser)

        assertEquals(Accuracy.MEDIUM, accuracy)
    }

    @Test
    fun `Must return MEDIUM Accuracy when 2 users have similar email name but different provider, and name and last name are similar in both users`() {
        val emailGmail = "some@gmail.com"
        val emailHotmail = "some@hotmail.com"
        val user = userRandom(name = "Juan", lastName = "Perez", email = emailGmail)
        val anotherUser = userRandom(name = "J", lastName = "P", email = emailHotmail)

        val accuracy = calculateScoring.execute(user, anotherUser)

        assertEquals(Accuracy.MEDIUM, accuracy)
    }

    @Test
    fun `Must return LOW Accuracy when 2 users have similar email name but different provider, and name or last is different in both users`() {
        val emailGmail = "some@gmail.com"
        val emailHotmail = "some@hotmail.com"
        val user = userRandom(name = "Juan", lastName = "Perez", email = emailGmail)
        val anotherUser = userRandom(name = "B", lastName = "M", email = emailHotmail)

        val accuracy = calculateScoring.execute(user, anotherUser)

        assertEquals(Accuracy.LOW, accuracy)
    }

    @Test
    fun `Must return LOW when users are totally different`() {
        val user = userRandom()
        val anotherUser = userRandom()

        val accuracy = calculateScoring.execute(user, anotherUser)

        assertEquals(Accuracy.LOW, accuracy)
    }
}
