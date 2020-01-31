package vn.sun.asterisk.domain.repository

import vn.sun.asterisk.domain.model.Part

interface PartRepository {

    suspend fun getParts(): List<Part>
}