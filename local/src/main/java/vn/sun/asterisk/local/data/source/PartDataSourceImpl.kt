package vn.sun.asterisk.local.data.source

import vn.sun.asterisk.data.data.source.PartDataSource
import vn.sun.asterisk.data.entity.PartEntity
import vn.sun.asterisk.local.db.AppDatabase
import vn.sun.asterisk.local.entity.LocalPart

class PartDataSourceImpl(
    private val database: AppDatabase
) : PartDataSource {

    override suspend fun getParts(): List<PartEntity> =
        database.partDao().getParts().map(LocalPart::map)
}