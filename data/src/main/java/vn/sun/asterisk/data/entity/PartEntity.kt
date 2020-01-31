package vn.sun.asterisk.data.entity

import vn.sun.asterisk.domain.model.Part

data class PartEntity(
    val id: Int,
    val name: String = "",
    val description: String = "",
    val total: String = "",
    val passed: String = "",
    val lastTime: String?
) : MappableData<Part> {

    override fun map() = Part(id, name, description, total, passed, lastTime)
}
