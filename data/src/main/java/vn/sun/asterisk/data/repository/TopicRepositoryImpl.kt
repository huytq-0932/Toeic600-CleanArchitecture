package vn.sun.asterisk.data.repository

import vn.sun.asterisk.data.data.source.TopicDataSource
import vn.sun.asterisk.data.entity.TopicEntity
import vn.sun.asterisk.domain.model.Topic
import vn.sun.asterisk.domain.repository.TopicRepository

class TopicRepositoryImpl(
    private val topicDataSource: TopicDataSource
) : TopicRepository {

    override suspend fun updateAllTopics(): List<Topic> =
        topicDataSource.updateAllTopics().map(TopicEntity::map)
}
