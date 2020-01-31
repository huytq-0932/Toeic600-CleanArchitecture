package vn.sun.asterisk.toeic600.ui.test.skills

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import vn.sun.asterisk.domain.model.Part
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseRecyclerAdapter
import vn.sun.asterisk.toeic600.ui.base.BaseViewHolder

class PartAdapter(
    private val onItemClick: (Part) -> Unit
) : BaseRecyclerAdapter<Part, PartViewHolder>(PartDiffUtilCallback()) {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_part

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PartViewHolder(
        itemView = getItemView(parent, viewType),
        onItemClick = onItemClick
    )

    class PartDiffUtilCallback : DiffUtil.ItemCallback<Part>() {
        override fun areItemsTheSame(oldItem: Part, newItem: Part) = oldItem === newItem

        override fun areContentsTheSame(oldItem: Part, newItem: Part) = oldItem == newItem
    }
}

class PartViewHolder(
    itemView: View,
    private val onItemClick: (Part) -> Unit
) : BaseViewHolder<Part>(itemView) {

    override fun onBindData(itemData: Part) = with(itemView) {
        super.onBindData(itemData)

    }

    override fun onItemClickListener(itemData: Part) = onItemClick(itemData)
}
