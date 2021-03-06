package com.example.maxisloginlogout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import login.Demo;

public class Info extends AppCompatActivity {

    private AdView mAdView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);


        Intent intent = getIntent();
        String myid = getIntent().getStringExtra("Object");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type typeListOfDesign = new TypeToken<Demo>(){}.getType();
        Demo design = gson.fromJson(myid, typeListOfDesign);

        TextView userName = (TextView)findViewById(R.id.sh_username);
        TextView userPhone = (TextView)findViewById(R.id.sh_userphone);
        TextView userTanentid = (TextView)findViewById(R.id.sh_usertanentid);
        TextView userRoleCode = (TextView)findViewById(R.id.sh_userrolecode);

        userName.setText("User Name : " +design.getResult().getUserId());
        userPhone.setText("User Phone : " +design.getResult().getUserPhone());
        userTanentid.setText("User TanentID : " +design.getResult().getTanentId());
        userRoleCode.setText("User Code : " +design.getResult().getRoleList()[0].getCode());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



    }
}
