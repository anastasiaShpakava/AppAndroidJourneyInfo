package com.company.journeyInfo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.company.journeyInfo.R;
import com.company.journeyInfo.viewModel.LogOutViewModel;
import com.google.firebase.auth.FirebaseUser;


public class UserPageFragment extends Fragment {
    private Button buttonLogOut;
    TextView textLoggedUser;
    private LogOutViewModel logOutViewModel;

    public UserPageFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logOutViewModel = ViewModelProviders.of(this).get(LogOutViewModel.class);
        logOutViewModel.getUserLiveData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    textLoggedUser.setText( firebaseUser.getEmail());
                    buttonLogOut.setEnabled(true);
                } else {
                    buttonLogOut.setEnabled(false);
                }
            }
        });
        logOutViewModel.getLoggedOutLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean loggedOut) {
                if (loggedOut) {
                    Toast.makeText(getContext(), "User Logged Out", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_page_fragment, container, false);

        buttonLogOut = view.findViewById(R.id.logOut);
        textLoggedUser = view.findViewById(R.id.textUserIfo);
        buttonLogOut.setOnClickListener(toLogOut);

        return view;
    }

    View.OnClickListener toLogOut = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            logOutViewModel.logOut();
            MainPageFragment mainPageFragment = new MainPageFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, mainPageFragment)
                    .addToBackStack(null).commit();
        }
    };
}
