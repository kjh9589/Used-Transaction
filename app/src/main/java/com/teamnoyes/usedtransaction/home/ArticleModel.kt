package com.teamnoyes.usedtransaction.home

data class ArticleModel(
    val sellerId: String,
    val title: String,
    val createdAt: Long,
    val price: String,
    val imageUrl: String
){
    // firebase RealtimeDatabase에서 모델을 그대로 사용하기 위해서는 빈 생성자가 있어야 한다.
    constructor(): this("", "", 0, "", "")
}
