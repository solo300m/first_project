package com.example.testshoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItemToList(shopItem:ShopItem)
    fun editShopItem (item: ShopItem)
    fun getShopItemFromList(id:Int):ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
    fun removeShopItem(shopItem: ShopItem)
}
