package com.company.journeyInfo.ui;

import android.os.Bundle;
import android.util.Log;
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

import com.company.journeyInfo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignUpFragment extends Fragment {
  //  private FirebaseAuth mAuth;
    private EditText editTextUsername, editTextEmail, editTextPassword, editTextCnfPassword;
    private Button buttonRegister;
    private TextView textViewLogin;


    public SignUpFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registration_fragment, container, false);
        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        editTextCnfPassword = view.findViewById(R.id.editTextCnfPassword);
        buttonRegister = view.findViewById(R.id.buttonRegister);
        textViewLogin = view.findViewById(R.id.textViewLogin);

       // mAuth = FirebaseAuth.getInstance();

        textViewLogin.setOnClickListener(onViewSignIn);
        buttonRegister.setOnClickListener(toSignUpNewUser);
        return view;
    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//    }
//
//    public void signUpNewUser(String email, String password) {
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d("TAG", "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            //  updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(getActivity(), "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            //  updateUI(null);
//                        }
//
//                        // ...
//                    }
//                });
//    }

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
            String userName = editTextUsername.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
            String passwordConf = editTextCnfPassword.getText().toString().trim();

         //   signUpNewUser(email,password);

            UserPageFragment userPageFragment = new UserPageFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, userPageFragment)
                    .addToBackStack(null).commit();
        }
    };
}

