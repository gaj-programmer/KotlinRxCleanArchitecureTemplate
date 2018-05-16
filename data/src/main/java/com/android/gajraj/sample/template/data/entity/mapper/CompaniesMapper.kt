package com.android.gajraj.sample.template.data.entity.mapper

import com.android.gajraj.sample.template.data.entity.ItemsResponse
import com.android.gajraj.sample.template.domain.model.ItemsResponseVO
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Gajraj on 4/21/2018.
 */
@Singleton
class CompaniesMapper @Inject constructor() : EntryEntityMapper<ItemsResponseVO, ItemsResponse>() {


    override fun transform(entity: ItemsResponse?): ItemsResponseVO? {
        var itemsResponse: ItemsResponseVO
        itemsResponse = ItemsResponseVO()
        itemsResponse.status = entity?.status
        return itemsResponse
    }


}