package com.example.csapp.csapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    private Button buttonTimetable;
    private TextView textViewEmail;
    private TextView textViewLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        firebaseAuth = FirebaseAuth.getInstance();


        FirebaseUser user = firebaseAuth.getCurrentUser();

        buttonTimetable = (Button) findViewById(R.id.buttonTimetable);

        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewEmail.setText("Hello， " + user.getEmail());
        textViewLogout = (TextView) findViewById(R.id.textViewLogout);
        textViewLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == textViewLogout)
        {
            firebaseAuth.signOut();

            finish();
            startActivity(new Intent(this, MainActivity.class));
        }


        if(v== buttonTimetable)
        {
            finish();
            startActivity(new Intent(this, TimetableActivity.class));
        }


    }
}
