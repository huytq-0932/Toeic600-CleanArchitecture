package vn.sun.asterisk.presentation.viewmodel

import androidx.lifecycle.liveData
import vn.sun.asterisk.domain.model.Category
import vn.sun.asterisk.domain.use.case.UseCaseNoParam

class CategoryViewModel(
    private val getCategoriesUseCase: UseCaseNoParam<List<Category>>
) : BaseViewModel() {

    val categories = liveData {
        _isLoading.value = true
        try {
            emit(getCategoriesUseCase.execute())
            _isLoading.value = false
        } catch (e: Exception) {
            emit(emptyList())
            _isLoading.value = false
        }
    }
}
