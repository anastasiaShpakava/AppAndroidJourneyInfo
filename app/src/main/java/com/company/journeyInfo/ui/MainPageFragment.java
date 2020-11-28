package com.company.journeyInfo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.company.journeyInfo.R;


public class MainPageFragment extends Fragment {
    private TextView textMainPage;
    private Button buttonRegister, buttonSignIn;

    public MainPageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_page_fragment, container, false);
        textMainPage = view.findViewById(R.id.text_latest_post);
        animationText(textMainPage);

        buttonSignIn = view.findViewById(R.id.signIn);
        buttonSignIn.setOnClickListener(onSignInPage);

        buttonRegister = view.findViewById(R.id.signUp);
        buttonRegister.setOnClickListener(onSignUpPage);
        return view;
    }

    View.OnClickListener onSignInPage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SignInFragment signInFragment = new SignInFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, signInFragment)
                    .addToBackStack(null).commit();
        }
    };
    View.OnClickListener onSignUpPage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SignUpFragment signUpFragment = new SignUpFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, signUpFragment)
                    .addToBackStack(null).commit();
        }
    };

    private void animationText(TextView textView) {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(980);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        textView.startAnimation(anim);
    }
}
