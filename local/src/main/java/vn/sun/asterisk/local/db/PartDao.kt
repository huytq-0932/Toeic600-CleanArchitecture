package vn.sun.asterisk.local.db

import androidx.room.Dao
import androidx.room.Query
import vn.sun.asterisk.local.entity.LocalPart

@Dao
interface PartDao {

    @Query("SELECT * FROM ${LocalPart.TABLE_NAME}")
    suspend fun getParts(): List<LocalPart>
}
