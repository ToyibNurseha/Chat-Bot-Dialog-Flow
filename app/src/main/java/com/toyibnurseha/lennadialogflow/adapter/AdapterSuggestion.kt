package com.toyibnurseha.lennadialogflow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.toyibnurseha.lennadialogflow.databinding.ItemMessagesSuggestionsBinding

class AdapterSuggestion : RecyclerView.Adapter<AdapterSuggestion.ViewHolder>() {

    private var suggestionList = ArrayList<String>()

    fun setSuggestionData(items: Array<String>) {
        suggestionList.clear()
        suggestionList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterSuggestion.ViewHolder {
        val view = ItemMessagesSuggestionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterSuggestion.ViewHolder, position: Int) {
        holder.bind(suggestionList[position])
    }

    override fun getItemCount(): Int = suggestionList.size

    inner class ViewHolder(private val binding: ItemMessagesSuggestionsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(suggestion: String) {
            binding.tvSuggestion.text = suggestion

            itemView.setOnClickListener {
                onClickListener?.let {
                    it(suggestion)
                }
            }

        }
    }

    private var onClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(clickListener: (String) -> Unit) {
        onClickListener = clickListener
    }

}