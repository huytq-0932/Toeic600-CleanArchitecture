package vn.sun.asterisk.domain.repository

import vn.sun.asterisk.domain.model.Topic

interface TopicRepository : Repository {

    suspend fun updateAllTopics(): List<Topic>
}
