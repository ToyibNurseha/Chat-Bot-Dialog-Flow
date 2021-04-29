package com.toyibnurseha.lennadialogflow.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.toyibnurseha.lennadialogflow.models.Chat

@Database(entities = [Chat::class], version = 1)
abstract class ChatDatabase : RoomDatabase() {

    abstract fun chatDao() : ChatDAO

    companion object {
        @Volatile
        private var instance: ChatDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        @JvmStatic
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ChatDatabase::class.java,
                "chat_db.db"
            ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

}