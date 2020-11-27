package com.company.journeyInfo.auth;

public interface AuthListener {
    void onStarted();

    void onSuccess();

    void onFailure(String message);
}
