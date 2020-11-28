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


public class SignUpFragment extends Fragment {
    private EditText editTextUsername, editTextEmail, editTextPassword, editTextCnfPassword;
    private Button buttonRegister;
    private TextView textViewLogin;
    private LoginRegisterViewModel loginRegisterViewModel;

    public SignUpFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginRegisterViewModel = ViewModelProviders.of(this).get(LoginRegisterViewModel.class);
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
        View view = inflater.inflate(R.layout.registration_fragment, container, false);
//        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
     //   editTextCnfPassword = view.findViewById(R.id.editTextCnfPassword);
        buttonRegister = view.findViewById(R.id.buttonRegister);
        textViewLogin = view.findViewById(R.id.textViewLogin);

        textViewLogin.setOnClickListener(onViewSignIn);
        buttonRegister.setOnClickListener(toSignUpNewUser);
        return view;
    }

    View.OnClickListener onViewSignIn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SignInFragment signInFragment = new SignInFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, signInFragment)
                    .addToBackStack(null).commit();
        }
    };
    View.OnClickListener toSignUpNewUser = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            if (email.length() > 0 && password.length() > 0) {
                loginRegisterViewModel.register(email, password);
            } else {
                Toast.makeText(getActivity(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show();
            }

        }
    };
}

