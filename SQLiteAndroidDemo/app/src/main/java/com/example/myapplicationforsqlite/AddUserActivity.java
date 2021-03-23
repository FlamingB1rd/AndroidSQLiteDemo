package com.example.myapplicationforsqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class AddUserActivity extends AppCompatActivity
{

    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;

    private TextInputLayout username;
    private TextInputLayout password;
    private TextInputLayout email;
    private TextInputLayout address;
    private TextInputLayout phone;
    private TextInputLayout years;
    private Button btnAddUser;
    private Button btnClear;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        alertDialogBuilder = new AlertDialog.Builder(this);

        final Database db = new Database(this);

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        email = findViewById(R.id.etEmail);
        address = findViewById(R.id.etAddress);
        phone = findViewById(R.id.etPhone);
        years = findViewById(R.id.etYears);
        btnAddUser = findViewById(R.id.btnConfirmAddUser);
        btnClear = findViewById(R.id.btnClearFields);
        btnBack = findViewById(R.id.btnBack);

        btnAddUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.addUser(new User(username.getEditText().getText().toString(), password.getEditText().getText().toString(),
                        email.getEditText().getText().toString(), address.getEditText().getText().toString(),
                        phone.getEditText().getText().toString(), years.getEditText().getText().toString()));
                ShowDialog("A new user has been successfully added!");
                alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Objects.requireNonNull(username.getEditText()).setText("");
                Objects.requireNonNull(password.getEditText()).setText("");
                Objects.requireNonNull(email.getEditText()).setText("");
                Objects.requireNonNull(address.getEditText()).setText("");
                Objects.requireNonNull(phone.getEditText()).setText("");
                Objects.requireNonNull(years.getEditText()).setText("");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AddUserActivity.this, WorkActivity.class));
            }
        });
    }

    public void ShowDialog(String ss)
    {
        alertDialogBuilder.setMessage(ss);
    }
}