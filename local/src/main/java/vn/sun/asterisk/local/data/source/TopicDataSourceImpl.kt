package vn.sun.asterisk.local.data.source

import vn.sun.asterisk.data.data.source.TopicDataSource
import vn.sun.asterisk.data.entity.TopicEntity
import vn.sun.asterisk.local.db.AppDatabase
import vn.sun.asterisk.local.entity.LocalWord

class TopicDataSourceImpl(
    private val database: AppDatabase
) : TopicDataSource {

    override suspend fun updateAllTopics(): List<TopicEntity> =
        database.topicDao().getTopics().map { localTopic ->
            getDetailTopicById(localTopic.id)
        }

    private suspend fun getDetailTopicById(id: Int): TopicEntity {
        val words = database.wordDao().getWordsByTopic(id)
        val numberMasterWords = words.filter(LocalWord::isMaster).size
        val numberNewWords = words.filter(LocalWord::isNever).size

        return database.topicDao().getTopicById(id).apply {
            total = words.size
            master = numberMasterWords
            newWord = numberNewWords
            database.topicDao().updateTopic(this)
        }.map()
    }
}
