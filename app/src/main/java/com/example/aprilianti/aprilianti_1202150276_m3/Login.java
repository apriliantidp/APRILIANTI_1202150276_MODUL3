package com.example.aprilianti.aprilianti_1202150276_m3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    username = (EditText) findViewById(R.id.username);
    password = (EditText) findViewById(R.id.password);;
    login = (Button) findViewById(R.id.button_login);

    }

    public void login (View view) {
        String username1 = username.getText().toString();
        String password1 = password.getText().toString();

        if (username1.equals("EAD") && password1.equals("MOBILE")) {

            Toast.makeText(Login.this, "Login Sukses", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(Login.this,MainActivity.class);
            a.putExtra("username", username1);
            startActivity(a);


        } else  {
            Toast.makeText(Login.this, "Login Gagaal", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(Login.this,Login.class);
            startActivity(a);
        }
    }

}
