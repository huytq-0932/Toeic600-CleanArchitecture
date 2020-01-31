package vn.sun.asterisk.domain.use.case

import vn.sun.asterisk.domain.model.Part
import vn.sun.asterisk.domain.repository.PartRepository

class GetPartsUseCaseImpl(
    private val repository: PartRepository
) : UseCaseNoParam<List<Part>> {
    override suspend fun execute(): List<Part> = repository.getParts()
}
