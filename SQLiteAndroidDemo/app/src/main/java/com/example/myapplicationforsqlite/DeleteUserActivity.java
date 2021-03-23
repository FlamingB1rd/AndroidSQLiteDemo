package com.example.myapplicationforsqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class DeleteUserActivity extends AppCompatActivity
{

    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;
    private List<User> users;

    private TextView username;
    private Button btnBack;
    private Button btnDeleteUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        final Database db = new Database(this);

        username = findViewById(R.id.txtDeleteUsername);
        btnBack = findViewById(R.id.btnDeleteBack);
        btnDeleteUser = findViewById(R.id.btnConfirmDeleteUser);

        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(DeleteUserActivity.this, WorkActivity.class));
            }
        });

        btnDeleteUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                users = db.getAllUsers();

                for (User us : users)
                {
                    if(username.getText().toString().equals(us.get_username()))
                    {
                        alertDialogBuilder.setMessage("Are you sure you want to delete this user: " + username.getText().toString() + " ?");
                        alertDialogBuilder.setPositiveButton("Yes", (dialog, which) -> {
                            db.deleteUser(us);
                        });
                        alertDialogBuilder.setNegativeButton("No", ((dialog, which) -> {
                            dialog.cancel();
                        }));
                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }
            }
        });
    }
}