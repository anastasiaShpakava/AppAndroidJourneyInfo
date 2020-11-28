package com.company.journeyInfo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.company.journeyInfo.R;
import com.company.journeyInfo.viewModel.LoginRegisterViewModel;
import com.google.firebase.auth.FirebaseUser;


public class SignInFragment extends Fragment {
    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;
    private TextView textViewRegister;
    private LoginRegisterViewModel loginRegisterViewModel;

    public SignInFragment() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginRegisterViewModel =  ViewModelProviders.of(this).get(LoginRegisterViewModel.class);
        loginRegisterViewModel.getUserLiveData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    Toast.makeText(getActivity(), "successfully logged", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sigin_fragment, container, false);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        buttonLogin = view.findViewById(R.id.buttonLogin);
        textViewRegister = view.findViewById(R.id.textViewRegister);

        textViewRegister.setOnClickListener(toSignUpView);
        buttonLogin.setOnClickListener(toSignIn);
        return view;
    }

    View.OnClickListener toSignIn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            if (email.length() > 0 && password.length() > 0) {
                loginRegisterViewModel.login(email, password);
            } else {
                Toast.makeText(getContext(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show();
            }
            UserPageFragment userPageFragment = new UserPageFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, userPageFragment)
                    .addToBackStack(null).commit();
        }
    };
    View.OnClickListener toSignUpView = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SignUpFragment signUpFragment = new SignUpFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, signUpFragment)
                    .addToBackStack(null).commit();
        }
    };
}
