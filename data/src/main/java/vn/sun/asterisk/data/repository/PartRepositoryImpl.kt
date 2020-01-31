package vn.sun.asterisk.data.repository

import vn.sun.asterisk.data.data.source.PartDataSource
import vn.sun.asterisk.data.entity.PartEntity
import vn.sun.asterisk.domain.model.Part
import vn.sun.asterisk.domain.repository.PartRepository

class PartRepositoryImpl(
    private val dataSource: PartDataSource
) : PartRepository {

    override suspend fun getParts(): List<Part> = dataSource.getParts().map(PartEntity::map)
}
