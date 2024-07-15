package com.example.prm392g9foodapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prm392g9foodapp.R;
import com.example.prm392g9foodapp.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();

    }
    private void setVariable()
    {
        binding.loginBtn.setOnClickListener(v -> {
            String email=binding.userEdt.getText().toString();
            String password=binding.passEdt.getText().toString();
            if(!email.isEmpty() && !password.isEmpty())
            {
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, task -> {
                    if(task.isSuccessful())
                    {
                        Log.i(TAG, "onComplete: ");
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                    else
                    {
                        Log.i(TAG, "failure: "+task.getException());
                        Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else
            {
                Toast.makeText(LoginActivity.this, "Please Fill UserName And Password", Toast.LENGTH_SHORT).show();
            }
        });
        TextView SingUpBtn = (TextView) findViewById(R.id.SingUpBtn);
        SingUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SingupActivity.class));
            }
        });
    }
}