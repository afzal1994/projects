package com.example.practise.views.activities;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.example.practise.BR;
import com.example.practise.R;
import com.example.practise.base.BaseActivity;
import com.example.practise.databinding.ActivityUsersBinding;
import com.example.practise.models.APIResponse;
import com.example.practise.models.UserEntity;
import com.example.practise.viewModel.UsersViewModel;
import com.example.practise.views.adapter.UsersAdapter;

import java.util.List;

public class UsersActivity extends BaseActivity<ActivityUsersBinding, UsersViewModel> {
    private UsersViewModel viewmodel;
    private ActivityUsersBinding mBinding;

    @Override
    public UsersViewModel getViewModel() {
        viewmodel = new UsersViewModel();
        return viewmodel;
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_users;
    }

    @Override
    public int getBindingVariable() {
        return BR.usersVM;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        viewmodel.getList();
        System.out.println(":EWdsax");
        viewmodel.getResponse().observe(this, new Observer<APIResponse>() {
            @Override
            public void onChanged(@Nullable APIResponse apiResponse) {
                if (apiResponse != null) parseResponse(apiResponse);
            }
        });
    }

    private void parseResponse(APIResponse apiResponse) {
        if (apiResponse.getStatus().equals("Success")) {
            List<UserEntity> listUsers = (List<UserEntity>) apiResponse.getResponse();
            mBinding.userRecycler.setLayoutManager(new LinearLayoutManager(this));
            mBinding.userRecycler.setAdapter(new UsersAdapter(listUsers, viewmodel));

        }
    }
}
