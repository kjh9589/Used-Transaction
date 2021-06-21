package com.teamnoyes.usedtransaction.chatlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.teamnoyes.usedtransaction.databinding.ItemArticleBinding
import com.teamnoyes.usedtransaction.databinding.ItemChatListBinding
import com.teamnoyes.usedtransaction.home.ArticleAdapter
import com.teamnoyes.usedtransaction.home.ArticleModel
import java.text.SimpleDateFormat
import java.util.*

class ChatListAdapter(val onItemClicked: (ChatListItem) -> Unit): ListAdapter<ChatListItem, ChatListAdapter.ChatListItemViewHolder>(diffUtil) {
    inner class ChatListItemViewHolder(private val binding: ItemChatListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(chatListItem: ChatListItem) {

            binding.root.setOnClickListener {
                onItemClicked(chatListItem)
            }

            binding.chatRoomTitleTextView.text = chatListItem.itemTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListItemViewHolder {
        return ChatListItemViewHolder(
            ItemChatListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatListItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ChatListItem>() {
            override fun areItemsTheSame(oldItem: ChatListItem, newItem: ChatListItem): Boolean {
                // 현재 리스트에 노출되고 있는 아이템이랑 새로운 아이템이 서로 같은지 확인
                // 새로운 값이 들어왔을 때 호출
                // 고유 키값으로 비교
                return oldItem.key == newItem.key

            }

            override fun areContentsTheSame(oldItem: ChatListItem, newItem: ChatListItem): Boolean {
                // 현재 리스트에 노출되고 있는 아이템이랑 새로운 아이템의 equals 비교
                return oldItem == newItem
            }
        }
    }
}