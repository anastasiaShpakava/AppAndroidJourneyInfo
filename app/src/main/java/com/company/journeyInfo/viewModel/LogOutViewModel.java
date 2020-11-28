package com.company.journeyInfo.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.company.journeyInfo.data.repository.AuthRepository;
import com.google.firebase.auth.FirebaseUser;

public class LogOutViewModel extends AndroidViewModel {
    private AuthRepository authAppRepository;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> loggedOutLiveData;

    public LogOutViewModel(@NonNull Application application) {
        super(application);

        authAppRepository = new AuthRepository(application);
        userLiveData = authAppRepository.getUserLiveData();
        loggedOutLiveData = authAppRepository.getLoggedOutLiveData();
    }

    public void logOut() {
        authAppRepository.logOut();
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<Boolean> getLoggedOutLiveData() {
        return loggedOutLiveData;
    }
}
