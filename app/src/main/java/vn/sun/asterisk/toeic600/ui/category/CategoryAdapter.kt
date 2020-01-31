package vn.sun.asterisk.toeic600.ui.category

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_category.view.*
import vn.sun.asterisk.domain.model.Category
import vn.sun.asterisk.domain.model.Topic
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseRecyclerAdapter
import vn.sun.asterisk.toeic600.ui.base.BaseViewHolder

internal class CategoryAdapter(
    private val onTopicClick: (Topic) -> Unit
) : BaseRecyclerAdapter<Category, CategoryViewHolder>(CategoryDiffUtilCallback()) {

    private val onItemClick = { position: Int, category: Category ->
        category.isExpanded = !category.isExpanded
        notifyItemChanged(position)
    }

    private val recyclerViewPool = RecyclerView.RecycledViewPool()

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_category

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            itemView = getItemView(parent, viewType),
            viewPool = recyclerViewPool,
            onItemClick = onItemClick,
            onTopicClick = onTopicClick
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBindData(position, getItem(position))
    }

    class CategoryDiffUtilCallback : DiffUtil.ItemCallback<Category>() {

        override fun areItemsTheSame(oldItem: Category, newItem: Category) = oldItem === newItem

        override fun areContentsTheSame(oldItem: Category, newItem: Category) = oldItem == newItem
    }
}

internal class CategoryViewHolder(
    itemView: View,
    viewPool: RecyclerView.RecycledViewPool,
    onTopicClick: (Topic) -> Unit = {},
    private val onItemClick: (Int, Category) -> Unit
) : BaseViewHolder<Category>(itemView) {

    private val topicAdapter = TopicAdapter(onTopicClick)

    init {
        itemView.recyclerTopics.apply {
            setRecycledViewPool(viewPool)
            adapter = topicAdapter
        }
    }

    override fun onBindData(itemPosition: Int, itemData: Category) {
        super.onBindData(itemPosition, itemData)

        itemView.run {
            relativeCategory?.setBackgroundColor(Color.parseColor(itemData.color))
            textTitleCategory?.text = itemData.name
            textTitleTopics?.text = itemData.topics.joinToString { it.name }

            if (itemData.isExpanded) {
                recyclerTopics?.isVisible = true
                imageExpand?.setImageResource(R.drawable.ic_keyboard_arrow_up)
            } else {
                recyclerTopics?.isVisible = false
                imageExpand?.setImageResource(R.drawable.ic_keyboard_arrow_down)
            }
        }
        topicAdapter.submitList(itemData.topics)
    }

    override fun onItemClickListener(itemData: Category) = onItemClick(itemPosition, itemData)
}
