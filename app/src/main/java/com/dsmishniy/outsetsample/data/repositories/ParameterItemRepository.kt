package com.dsmishniy.outsetsample.data.repositories

import com.dsmishniy.outsetsample.data.entities.ParameterItem

interface ParameterItemRepository {
    fun getParameterItems(): List<ParameterItem>
}