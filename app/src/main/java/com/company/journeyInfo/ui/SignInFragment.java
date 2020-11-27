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


public class SignInFragment extends Fragment {
   // private FirebaseAuth mAuth;
    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;
    private TextView textViewRegister;

    public SignInFragment() {
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

      //  mAuth = FirebaseAuth.getInstance();
        return view;
    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//    }
//    public void signIn (String email, String password){
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d("TAG", "signInWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                         //   updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w("TAG", "signInWithEmail:failure", task.getException());
//                            Toast.makeText(getActivity(), "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                        //    updateUI(null);
//                        }
//
//                        // ...
//                    }
//                });
//    }

    View.OnClickListener toSignIn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();
           // signIn(email, password);

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
