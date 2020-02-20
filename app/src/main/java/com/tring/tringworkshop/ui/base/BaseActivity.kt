package com.tring.tringworkshop.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.databinding.DataBindingUtil


abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    private lateinit var viewDataBinding: ViewDataBinding
    private var viewModel: BaseViewModel? = null

    /**
     * Method to set the respective binding variable of the Activity
     */
    abstract fun getBindingVariable(): Int

    /**
     * Method to set the respective Layout Id for the Activity
     */
    abstract fun getLayoutId(): Int

    /**
     * Method to set the respective View model for the Activity
     */
    abstract fun getViewModel(): VM

    /**
     * Method to get the Binding reference
     */
    abstract fun getViewDataBinding(): V

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        performDataBinding()
    }

    /**
     * Method to perform Binding operations
     */
    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.viewModel = if (viewModel == null) getViewModel() else viewModel
        viewDataBinding.setVariable(getBindingVariable(), viewModel)
        viewDataBinding.executePendingBindings()
    }

}