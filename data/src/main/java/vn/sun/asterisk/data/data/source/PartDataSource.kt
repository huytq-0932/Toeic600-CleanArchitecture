package vn.sun.asterisk.data.data.source

import vn.sun.asterisk.data.entity.PartEntity

interface PartDataSource {

    suspend fun getParts(): List<PartEntity>
}
