package vn.sun.asterisk.toeic600.ui.test.skills

import androidx.lifecycle.Observer
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.get
import org.koin.core.qualifier.named
import vn.sun.asterisk.common.KoinTags
import vn.sun.asterisk.domain.model.Part
import vn.sun.asterisk.presentation.viewmodel.TestSkillsViewModel
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseFragment

class TestSkillsFragment : BaseFragment<TestSkillsViewModel>() {

    override val layoutResource: Int get() = R.layout.test_skills_fragment

    override val viewModel by viewModel<TestSkillsViewModel>()

    private val partPhotoResIds = get<List<Int>>(named(KoinTags.PART_PHOTO_RES_IDS))

    override fun initComponents() {

    }

    override fun observeData() {
        super.observeData()

        viewModel.parts.observe(viewLifecycleOwner, Observer(::showParts))
    }

    private fun showParts(parts: List<Part>) {
    }
}
