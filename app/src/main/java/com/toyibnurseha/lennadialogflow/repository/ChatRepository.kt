package com.toyibnurseha.lennadialogflow.repository

import com.toyibnurseha.lennadialogflow.db.ChatDatabase
import com.toyibnurseha.lennadialogflow.models.Chat

class ChatRepository(val db: ChatDatabase) {

    suspend fun insertChatList(chat: Chat) = db.chatDao().insert(chat)

    suspend fun nukeChatList() = db.chatDao().nukeChatList()

    fun getChatList() = db.chatDao().getListChat()

}