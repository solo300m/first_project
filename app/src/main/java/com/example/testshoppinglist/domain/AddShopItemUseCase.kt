package com.example.testshoppinglist.domain

class AddShopItemUseCase (private val shopListRepository: ShopListRepository){
    fun addShopItemToList(shopItem:ShopItem){
        shopListRepository.addShopItemToList(shopItem)
    }
}
