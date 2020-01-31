package vn.sun.asterisk.domain.model

data class Part(
    val id: Int,
    val name: String = "",
    val description: String = "",
    val total: String = "",
    val passed: String = "",
    val lastTime: String?,
    val imageResId: Int = 0
)
