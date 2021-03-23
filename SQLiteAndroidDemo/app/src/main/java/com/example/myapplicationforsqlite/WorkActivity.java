package com.example.myapplicationforsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class WorkActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        final Database db = new Database(this);
        final List<User> users = db.getAllUsers();

        final AutoCompleteTextView textUsers = (AutoCompleteTextView) findViewById(R.id.actvText);
        Button Logout = (Button) findViewById(R.id.btnLogout);
        Button showAllUsers = (Button) findViewById(R.id.btnShowAll);
        Button addUser = (Button) findViewById(R.id.btnAddUser);
        Button delete = (Button) findViewById(R.id.btnDeleteUser);
        Button deleteAll = (Button) findViewById(R.id.btnApocalypse);
        Button searchUser = findViewById(R.id.btnSearch);

        searchUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(WorkActivity.this, SearchActivity.class));
            }
        });

        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(WorkActivity.this, DeleteUserActivity.class));
            }
        });

        deleteAll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db.onDeleteTable();
                Toast.makeText(WorkActivity.this,"The table has been deleted successfully!", Toast.LENGTH_LONG).show();
            }
        });

        addUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(WorkActivity.this, AddUserActivity.class));
            }
        });

        showAllUsers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                textUsers.setText("");
                for (User us : users)
                {
                    String log = textUsers.getText() +"\n" + "Id: " + us.get_id() + " ,Name: " + us.get_username() + " ,Pass: " + us.get_password() ;
                    textUsers.setText(log);
                }
                Toast.makeText(WorkActivity.this,"All users are loaded!", Toast.LENGTH_LONG).show();
            }
        });

        Logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(WorkActivity.this, MainActivity.class));
            }
        });

    }
}