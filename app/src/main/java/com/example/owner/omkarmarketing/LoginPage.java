package com.example.owner.omkarmarketing;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    EditText user,pass;
    Button login, register;
    LinearLayout screen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        user = findViewById(R.id.loginid);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.butlogin);
        screen = findViewById(R.id.layout);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, signup.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname= user.getText().toString();
                String pname= pass.getText().toString();
//                if (uname.equals("tanaya")&& pname.equals("tanaya"))
//                {
//                    Toast.makeText(getApplicationContext(),"user Authenticated", Toast.LENGTH_LONG).show();
//                    screen.setBackgroundResource(R.color.blue);
//                    startActivity(new Intent(LoginPage.this, homepage.class));
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "User Not Found", Toast.LENGTH_LONG).show();
//                }

                FirebaseAuth.getInstance().signInWithEmailAndPassword(uname, pname).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            startActivity(new Intent(LoginPage.this, homepage.class));
                        } else {
                            Toast.makeText(LoginPage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        

    }
}
