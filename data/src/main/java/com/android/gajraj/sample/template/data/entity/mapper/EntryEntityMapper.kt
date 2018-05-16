package com.android.gajraj.sample.template.data.entity.mapper

/**
 * Created by Gajraj on 4/21/2018.
 */
abstract class EntryEntityMapper<Model, Entity> {

    abstract fun transform(entity: Entity?): Model?

    fun transform(collection: Collection<Entity>): List<Model> {
        val list = ArrayList<Model>()
        var model: Model?
        for (entity in collection) {
            model = transform(entity)
            if (model != null) {
                list.add(model)
            }
        }
        return list
    }
}