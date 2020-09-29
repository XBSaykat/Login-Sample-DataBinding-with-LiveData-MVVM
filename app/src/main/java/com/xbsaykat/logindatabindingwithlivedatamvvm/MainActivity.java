package com.xbsaykat.logindatabindingwithlivedatamvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;

import com.xbsaykat.logindatabindingwithlivedatamvvm.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginViewModel= ViewModelProviders.of(this).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(loginViewModel);

        loginViewModel.getUser().observe(this, new Observer<LoginUser>() {
            @Override
            public void onChanged(LoginUser loginUser) {
                if(TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrEmail())){
                    binding.txtEmailAddress.setError("Enter Email Address");
                    binding.txtEmailAddress.requestFocus();
                }
                else if(!loginUser.isEmailValid()){
                    binding.txtEmailAddress.setError("Enter a Valid Email Address");
                    binding.txtPassword.requestFocus();
                }
                else if(TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrPassword())){
                    binding.txtPassword.setError("Enter Password");
                    binding.txtPassword.requestFocus();
                }else{
                    binding.lblEmailAnswer.setText(loginUser.getStrEmail());
                    binding.lblPasswordAnswer.setText(loginUser.getStrPassword());
                }
            }
        });
    }
}