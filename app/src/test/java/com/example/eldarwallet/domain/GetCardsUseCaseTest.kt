package com.example.eldarwallet.domain

import com.example.eldarwallet.data.CardRepository
import com.example.eldarwallet.data.model.CardModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCardsUseCaseTest {

    @RelaxedMockK
    private lateinit var cardRepository: CardRepository

    lateinit var getCardsUseCase: GetCardsUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)

        getCardsUseCase = GetCardsUseCase(cardRepository)
    }

    @Test
    fun `when the data base doesnt return anything`() = runBlocking {
        //Given
        coEvery { cardRepository.getCards() } returns emptyList()
        //When
        val response = getCardsUseCase()
        //Then
        assert(response != null)

    }

    @Test
    fun `when the data base return something`() = runBlocking {
        //Given
        val myList = listOf(
            CardModel(
                "Visa", "1122334455667788",
                "123", "11"
            )
        )
        coEvery { cardRepository.getCards() } returns myList

        //When
        val response = getCardsUseCase()

        //Then
        assert(myList == response)
    }


}