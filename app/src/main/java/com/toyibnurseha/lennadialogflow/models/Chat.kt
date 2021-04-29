package com.toyibnurseha.lennadialogflow.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_chat")
data class Chat(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_chat")
    val id: Int,

    @ColumnInfo(name = "agent_res")
    val responseAgent: String = "",

    @ColumnInfo(name = "user_msg")
    val msgUser: String

)