package com.example.eldarwallet.core.di

import android.content.Context
import androidx.room.Room
import com.example.eldarwallet.data.database.CardDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val CARD_DATABASE_NAME = "CARD_DATABASE"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): CardDataBase {
        return Room.databaseBuilder(context,CardDataBase::class.java, CARD_DATABASE_NAME).build()
    }
    @Singleton
    @Provides
    fun provideDrinkDao(db: CardDataBase) = db.getCardDao()
}