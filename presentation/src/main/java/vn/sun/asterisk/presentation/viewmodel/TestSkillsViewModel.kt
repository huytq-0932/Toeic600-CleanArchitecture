package vn.sun.asterisk.presentation.viewmodel

import androidx.lifecycle.liveData
import vn.sun.asterisk.common.Constants
import vn.sun.asterisk.domain.model.Part
import vn.sun.asterisk.domain.use.case.UseCaseNoParam

class TestSkillsViewModel(
    private val getPartsUseCase: UseCaseNoParam<List<Part>>
) : BaseViewModel() {

    val parts = liveData<List<Part>> {
        try {
            emit(getPartsUseCase.execute().take(Constants.NUMBER_OF_PARTS))
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}
