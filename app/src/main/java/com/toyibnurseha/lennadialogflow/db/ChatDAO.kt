package com.toyibnurseha.lennadialogflow.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.toyibnurseha.lennadialogflow.models.Chat

@Dao
interface ChatDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(chat: Chat): Long

    @Query("SELECT * FROM tb_chat")
    fun getListChat(): LiveData<List<Chat>>

    @Query("SELECT id_chat from tb_chat WHERE id_chat == :id")
    fun getChatId(id: Int): Int

    @Query("DELETE FROM tb_chat")
    suspend fun nukeChatList()

}