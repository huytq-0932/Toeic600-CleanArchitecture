package vn.sun.asterisk.data.repository

import vn.sun.asterisk.data.data.source.CategoryDataSource
import vn.sun.asterisk.data.data.source.TopicDataSource
import vn.sun.asterisk.data.entity.CategoryEntity
import vn.sun.asterisk.domain.model.Category
import vn.sun.asterisk.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val categoryDataSource: CategoryDataSource,
    private val topicDataSource: TopicDataSource
) : CategoryRepository {

    override suspend fun getCategories(): List<Category> {
        topicDataSource.updateAllTopics()
        return categoryDataSource.getCategories().map(CategoryEntity::map)
    }
}
