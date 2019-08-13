package com.example.thursday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText email;
    private Button button;
    private Intent intent = new Intent(this, SecondActivity.class);
    private SessionMananger sharedPrefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.text_username);
        password = findViewById(R.id.text_password);
        email = findViewById(R.id.text_email);
        button = findViewById(R.id.signin);
        sharedPrefManager = new SessionMananger(this);

        if (sharedPrefManager.getIsLogin()){
            startActivity(new Intent(MainActivity.this, SecondActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uName = username.getText().toString().trim();
                String pWord = password.getText().toString().trim();
                String eMail = email.getText().toString().trim();

                if (uName.isEmpty() && pWord.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Please Fill all details", Toast.LENGTH_SHORT).show();
                } else if (uName.equals("admin") && pWord.equals("admin")){
                    intent = new Intent(MainActivity.this, SecondActivity.class);
                    sharedPrefManager.saveSharedPrefBoolean(SessionMananger.IS_LOGIN, true);
                    sharedPrefManager.saveSharedPrefString(SessionMananger.PREF_USERNAME, uName);
                    Toast.makeText(MainActivity.this,"Log in Successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,"Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}