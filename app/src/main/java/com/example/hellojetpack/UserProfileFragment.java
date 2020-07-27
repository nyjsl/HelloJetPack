package com.example.hellojetpack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hellojetpack.databinding.FragmentUserProfileBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author : weixing
 * @date : 2020/7/27 10:30 AM
 */
public class UserProfileFragment extends Fragment {


    private UserProfileViewModel userProfileViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userProfileViewModel = new ViewModelProvider(this,
                new SavedStateViewModelFactory(getActivity().getApplication(), this))
                .get(UserProfileViewModel.class);
        userProfileViewModel.setUserId("13657230465");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_user_profile, container, false);
        FragmentUserProfileBinding fragmentUserProfileBinding = DataBindingUtil.bind(inflate);
        fragmentUserProfileBinding.setUser(userProfileViewModel.getUser());
        fragmentUserProfileBinding.setLifecycleOwner(this);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
