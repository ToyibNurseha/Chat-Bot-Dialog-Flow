package com.toyibnurseha.lennadialogflow.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.toyibnurseha.lennadialogflow.repository.ChatRepository

class ViewModelProviderFactory(val app: Application, private val repository: ChatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChatViewModel(app, repository) as T
    }
}