package com.example.myapplicationforsqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SearchActivity extends AppCompatActivity
{
    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;


    private AutoCompleteTextView result;
    private TextView usernameSearch;
    private Button btnBack;
    private Button btnFindUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final Database db = new Database(this);
        final List<User> users = db.getAllUsers();

        result = findViewById(R.id.actvSearchedUser);
        usernameSearch = findViewById(R.id.txtSearchUser);
        btnBack = findViewById(R.id.btnSearchBack);
        btnFindUser = findViewById(R.id.btnSearchFindUser);

        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(SearchActivity.this, WorkActivity.class));
            }
        });

        btnFindUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                result.setText("");
                for (User us : users)
                {
                    if(us.get_username().equals(usernameSearch.getText().toString()))
                    {
                        String log =
                                "Id: " + us.get_id() +
                                "\nName: " + us.get_username() +
                                "\nPass: " + us.get_password() +
                                "\nPhone: " + us.get_username() +
                                "\nEmail: " + us.get_password() +
                                "\nAddress: " + us.get_username() +
                                 "\nYears: " + us.get_password();
                        result.setText(log);
                        break;
                    }
                    else
                    {
                        String log = "No such user found!";
                        result.setText(log);
                    }
                }
            }
        });
    }
}