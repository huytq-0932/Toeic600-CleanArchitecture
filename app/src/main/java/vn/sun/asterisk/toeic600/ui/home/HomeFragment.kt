package vn.sun.asterisk.toeic600.ui.home

import org.koin.android.viewmodel.ext.android.viewModel
import vn.sun.asterisk.presentation.viewmodel.HomeViewModel
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseFragment

class HomeFragment : BaseFragment<HomeViewModel>() {

    override val layoutResource: Int get() = R.layout.home_fragment
    override val viewModel by viewModel<HomeViewModel>()

    override fun initComponents() {
    }
}
