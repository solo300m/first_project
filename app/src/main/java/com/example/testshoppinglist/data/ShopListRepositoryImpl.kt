package com.example.testshoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testshoppinglist.domain.ShopItem
import com.example.testshoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopListLiveData = MutableLiveData<List<ShopItem>>()
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0
    init {
        for (i in 0 until 10){
            val item = ShopItem("Name $i",i, true)
            addShopItemToList(item)
        }
    }

    override fun addShopItemToList(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun editShopItem(item: ShopItem) {
        val oldShopItem = getShopItemFromList(item.id)
        shopList.remove(oldShopItem)
        addShopItemToList(item)
    }

    override fun getShopItemFromList(id: Int): ShopItem {
        return shopList.find { it.id == id }
            ?: throw RuntimeException("Element with Id $id not found!")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLiveData //возврат копии shopList для обеспечения безопасности данных
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }
    private fun updateList(){
        shopListLiveData.value = shopList.toList()
    }
}
