package com.example.myapplicationforsqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder alertDialogBuilder;
    AlertDialog alertDialog;
    User Rec1 = new User(1,"admin", "1234", "fallenStar@gmail.com", "Yadayada", "0886595", "21");
    final Database db = new Database(this);
    private List<User> users;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView userName = findViewById(R.id.txtUsername);
        final TextView password = findViewById(R.id.txtPass);
        final Button login =  findViewById(R.id.btnLogin);

        ImageView img = (ImageView) findViewById(R.id.imgProfile);
        img.setImageResource(R.mipmap.ic_launcher);

        alertDialogBuilder = new AlertDialog.Builder(this);
        db.addUser(Rec1);

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                users = db.getAllUsers();
                boolean log = true;

                for (User us : users)
                {
                    boolean correctPass = false;
                    try
                    {
                        correctPass = Database.validatePassword(password.getText().toString(), us.get_password());
                    } catch (NoSuchAlgorithmException | InvalidKeySpecException e)
                    {
                        e.printStackTrace();
                    }
                    if(userName.getText().toString().equals(us.get_username()) && correctPass)
                    {
                        log = false;
                        open("Login Successful !", log);
                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        break;
                    }
                }
                if(log)
                {
                    open("Unsuccessful !",log);
                    alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }
        });
    }

    public void open(String ss, boolean log)
    {
        alertDialogBuilder.setMessage(ss);
        alertDialogBuilder.setPositiveButton("Ок", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface arg0, int arg1)
            {
                if(!log)
                    startActivity(new Intent(MainActivity.this, WorkActivity.class));
            }
        });
    }
}