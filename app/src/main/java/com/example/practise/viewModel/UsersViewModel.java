package com.example.practise.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.view.View;

import com.example.practise.base.ApiClient;
import com.example.practise.base.ApiInterface;
import com.example.practise.base.BaseViewModel;
import com.example.practise.interfaces.Constants;
import com.example.practise.models.APIResponse;
import com.example.practise.models.UserEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersViewModel extends BaseViewModel {
    private MutableLiveData<APIResponse> responseData = new MutableLiveData<>();

    public LiveData<APIResponse> getResponse() {
        return responseData;
    }

    public void getList() {
        showLoader.set(View.VISIBLE);
        ApiInterface apiInterface = ApiClient.getClient(Constants.BASE_URL).create(ApiInterface.class);
        Call<List<UserEntity>> call = apiInterface.getMoviesList();
        call.enqueue(new Callback<List<UserEntity>>() {
            @Override
            public void onResponse(Call<List<UserEntity>> call, Response<List<UserEntity>> response) {
                showLoader.set(View.GONE);
                System.out.println("efsd" + response.message());
                System.out.println("efsd" + response.errorBody());
                System.out.println("efsd" + response.raw());
                responseData.setValue(new APIResponse(response.body(), "Success"));


            }

            @Override
            public void onFailure(Call<List<UserEntity>> call, Throwable t) {
                showLoader.set(View.GONE);
                System.out.println("efsd" + t.getLocalizedMessage());

                responseData.setValue(new APIResponse(t, "Error"));
            }
        });
    }
}
