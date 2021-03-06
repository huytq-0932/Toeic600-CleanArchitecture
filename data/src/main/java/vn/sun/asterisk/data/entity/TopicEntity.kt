package vn.sun.asterisk.data.entity

import vn.sun.asterisk.domain.model.Topic

data class TopicEntity(
    val id: Int = 0,
    val name: String = "",
    val imageUrl: String = "",
    val category: String = "",
    val color: String? = null,
    val lastTime: String? = null,
    val total: Int = 12,
    val master: Int = 0,
    val newWord: Int = 0,
    val remind: Int = 0
) : DataEntity(), MappableData<Topic> {

    override fun map() =
        Topic(id, name, imageUrl, category, color, lastTime, total, master, newWord, remind)
}
