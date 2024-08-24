package com.example.testshoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testshoppinglist.data.ShopListRepositoryImpl
import com.example.testshoppinglist.domain.EditShopItemUseCase
import com.example.testshoppinglist.domain.GetShopListUseCase
import com.example.testshoppinglist.domain.RemoveShopItemUseCase
import com.example.testshoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun removeShopList(shopItem: ShopItem){
        removeShopItemUseCase.removeShopItem(shopItem)

    }
    fun editShopList(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)

    }
}
