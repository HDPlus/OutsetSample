package com.dsmishniy.outsetsample.domain.repositories

import com.dsmishniy.outsetsample.data.entities.ParameterItem
import com.dsmishniy.outsetsample.data.repositories.ParameterItemRepository

class ParameterItemRepoImpl: ParameterItemRepository {
    override fun getParameterItems(): List<ParameterItem> {
        return listOf(
            ParameterItem("Treatment Type", "HD"),
            ParameterItem("Dialysate \n Flow Rate", "SmartFlow™", additionalInfo = true),
            ParameterItem("Fluid Removal Goal", "1200", "mL"),
            ParameterItem("Treatment Duration", "6:00", "hours"),
            ParameterItem("Blood Flow Rate", "350", "mL/min"),
            ParameterItem("Dialysate Temp", "36.0", "C")
        )
    }
}