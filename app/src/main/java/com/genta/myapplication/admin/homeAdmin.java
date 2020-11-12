package com.genta.myapplication.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import com.genta.myapplication.R;
import com.genta.myapplication.session.PrefSetting;
import com.genta.myapplication.session.SessionManager;
import com.genta.myapplication.users.LoginActivity;

public class homeAdmin extends AppCompatActivity {

    SessionManager session;
    SharedPreferences prefs;
    PrefSetting prefSetting;
    CardView cardExit, cardDataKacamata, cardInputKacamata, cardProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        prefSetting = new PrefSetting(this);
        prefs = prefSetting.getSharePreferences();

        session = new SessionManager(homeAdmin.this);

        prefSetting.islogin(session, prefs);


        cardExit = (CardView) findViewById(R.id.cardExit);
        cardDataKacamata = (CardView) findViewById(R.id.cardDataKacamata);
        cardInputKacamata = (CardView) findViewById(R.id.cardInputKacamata);
        cardProfile = (CardView) findViewById(R.id.cardProfile);

        cardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setLogin(false);
                session.setSessid(0);
                Intent i = new Intent(homeAdmin.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        cardDataKacamata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homeAdmin.this, ActivityDataKacamata.class);
                startActivity(i);
                finish();
            }
        });

        cardInputKacamata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homeAdmin.this, InputDataKacamata.class);
                startActivity(i);
                finish();
            }
        });

        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homeAdmin.this, Profile.class);
                startActivity(i);
                finish();
            }
        });

    }
}