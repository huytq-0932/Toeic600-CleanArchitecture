package vn.sun.asterisk.data.data.source

import vn.sun.asterisk.data.entity.TopicEntity

interface TopicDataSource : DataSource {

    suspend fun updateAllTopics(): List<TopicEntity>
}