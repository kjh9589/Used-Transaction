package com.teamnoyes.usedtransaction.chatdetail

data class ChatItem(
    val senderId: String,
    val message: String
){
    constructor(): this("", "")
}
