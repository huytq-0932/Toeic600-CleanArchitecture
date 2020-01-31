package vn.sun.asterisk.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import vn.sun.asterisk.data.entity.MappableData
import vn.sun.asterisk.data.entity.PartEntity

@Entity(tableName = LocalPart.TABLE_NAME)
data class LocalPart(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = FIELD_ID) val id: Int,
    @ColumnInfo(name = FIELD_NAME) val name: String = "",
    @ColumnInfo(name = FIELD_DESCRIPTION) val description: String = "",
    @ColumnInfo(name = FIELD_TOTAL) val total: String = "",
    @ColumnInfo(name = FIELD_PASSED) val passed: String = "",
    @ColumnInfo(name = FIELD_LAST_TIME) val lastTime: String?
) : MappableData<PartEntity> {

    override fun map() = PartEntity(id, name, description, total, passed, lastTime)

    companion object {
        const val TABLE_NAME = "tbl_part"
        const val FIELD_ID = "id"
        const val FIELD_NAME = "name"
        const val FIELD_DESCRIPTION = "desctiption"
        const val FIELD_TOTAL = "total"
        const val FIELD_PASSED = "passed"
        const val FIELD_LAST_TIME = "last_time"
    }
}
