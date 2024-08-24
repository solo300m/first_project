package com.example.testshoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItemFromList(id:Int):ShopItem{
        return shopListRepository.getShopItemFromList(id)
    }
}
