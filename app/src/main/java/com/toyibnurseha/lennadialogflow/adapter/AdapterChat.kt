package com.toyibnurseha.lennadialogflow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toyibnurseha.lennadialogflow.databinding.ItemMessagesBinding
import com.toyibnurseha.lennadialogflow.models.Chat

class AdapterChat : RecyclerView.Adapter<AdapterChat.ViewHolder>() {

    /* since there aren't indicator for which is sender / receiver
    than the bubble layout can be in one xml
     */

    private var chatList = ArrayList<Chat>()

    fun setData(items: List<Chat>) {
        chatList.clear() //clear the old list before initiate a new list
        chatList.addAll(items) // adding new data list to array
        notifyDataSetChanged() // notify the adapter to refresh the data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterChat.ViewHolder {
        val view = ItemMessagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterChat.ViewHolder, position: Int) {
        holder.bind(chatList[position])
    }

    override fun getItemCount(): Int = chatList.size

    inner class ViewHolder(private val binding : ItemMessagesBinding ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            binding.tvMessageOutcoming.text = chat.msgUser
            binding.tvMessageIncoming.text = chat.responseAgent
        }
    }
}