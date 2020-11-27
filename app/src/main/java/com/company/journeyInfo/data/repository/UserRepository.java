package com.company.journeyInfo.data.repository;

import com.company.journeyInfo.data.firebase.FirebaseSource;

public class UserRepository {
    private FirebaseSource firebaseSource;

    public void signIn(String email, String password) {
        firebaseSource.signIn(email, password);
    }

    public void signUp(String email, String password) {
        firebaseSource.signUpNewUser(email, password);
    }

    public void signOut() {
        firebaseSource.signOut();
    }

    public void currentUser() {
        firebaseSource.currentUser();
    }
}
