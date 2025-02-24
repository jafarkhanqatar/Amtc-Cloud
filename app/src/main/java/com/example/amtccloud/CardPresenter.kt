package com.example.amtccloud

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter

class CardPresenter : Presenter() {

    private var defaultBackgroundColor: Int = 0
    private var selectedBackgroundColor: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val context = parent.context
        defaultBackgroundColor = ContextCompat.getColor(context, R.color.default_background)
        selectedBackgroundColor = ContextCompat.getColor(context, R.color.selected_background)

        val cardView = object : ImageCardView(context) {
            override fun setSelected(selected: Boolean) {
                super.setSelected(selected)
                setBackgroundColor(if (selected) selectedBackgroundColor else defaultBackgroundColor)
            }
        }

        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val cardView = viewHolder.view as ImageCardView
        if (item is Movie) {
            cardView.titleText = item.title
            cardView.contentText = item.studio
            cardView.setMainImageDimensions(313, 176)
            cardView.setMainImage(null) // Placeholder until image is loaded
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        val cardView = viewHolder.view as ImageCardView
        cardView.badgeImage = null
        cardView.mainImage = null
    }
}