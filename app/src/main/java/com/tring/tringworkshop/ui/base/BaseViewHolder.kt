package com.tring.tringworkshop.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(view: ViewDataBinding) :
    RecyclerView.ViewHolder(view.root) {

    abstract fun updateContent(position: Int)

}