package com.tring.tringworkshop.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<V : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    private lateinit var viewDataBinding: ViewDataBinding
    private var viewModel: BaseViewModel? = null

    /**
     * Method to set the respective binding variable of the Fragment
     */
    abstract fun getBindingVariable(): Int

    /**
     * Method to set the respective Layout Id for the Fragment
     */
    abstract fun getLayoutId(): Int

    /**
     * Method to set the respective View model for the Fragment
     */
    abstract fun getViewModel(): VM

    /**
     * Method to get the Binding reference of the Fragment
     */
    abstract fun getViewDataBinding(): V

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}