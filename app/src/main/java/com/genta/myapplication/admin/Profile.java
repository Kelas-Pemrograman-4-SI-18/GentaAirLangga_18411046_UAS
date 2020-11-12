package com.genta.myapplication.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.genta.myapplication.R;
import com.genta.myapplication.session.PrefSetting;

public class Profile extends AppCompatActivity {

    TextView txtUserName, txtNamaLengkap, txtEmail, txtNotelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setTitle("Profile Admin");

        txtUserName = (TextView) findViewById(R.id.userName);
        txtNamaLengkap = (TextView) findViewById(R.id.namaLengkap);
        txtEmail = (TextView) findViewById(R.id.email);
        txtNotelp = (TextView) findViewById(R.id.noTelp);

        txtUserName.setText(PrefSetting.userName);
        txtNamaLengkap.setText(PrefSetting.namaLengkap);
        txtEmail.setText(PrefSetting.email);
        txtNotelp.setText(PrefSetting.noTelp);

    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(Profile.this, homeAdmin.class);
        startActivity(i);
        finish();
    }

}