package com.example.practise.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    private T mBinding;
    private V mViewModel;
    public abstract V getViewModel();
    public abstract int getContentLayout();
    public abstract int getBindingVariable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
       }

    public void initBinding() {
        mBinding = DataBindingUtil.setContentView(this, getContentLayout());
        mViewModel = getViewModel();
        mBinding.setVariable(getBindingVariable(), mViewModel);
    }

    public T getViewDataBinding() {
        return mBinding;
    }

}
