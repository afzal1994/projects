package com.example.practise.views.adapter;

import com.example.practise.R;
import com.example.practise.base.BaseAdapter;
import com.example.practise.models.UserEntity;
import com.example.practise.viewModel.UsersViewModel;

import java.util.List;

public class UsersAdapter extends BaseAdapter<UsersViewModel> {
    private UsersViewModel viewModel;
    private List<UserEntity> data;

    public UsersAdapter(List<UserEntity> data, UsersViewModel viewModel) {
        this.viewModel = viewModel;
        this.data = data;
    }

    @Override
    public UserEntity getObjectForPosition(int position) {
        return data.get(0);
    }

    @Override
    public UsersViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public int getLayoutForPosition(int position) {
        return R.layout.users_item;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
