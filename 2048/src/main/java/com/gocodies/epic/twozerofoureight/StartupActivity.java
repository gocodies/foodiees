package com.gocodies.epic.twozerofoureight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class StartupActivity extends AppCompatActivity {
    Button playbut;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_startup);

        playbut = (Button)findViewById(R.id.playbut);

        playbut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(StartupActivity.this, MainActivity.class));
                playbut.setText(getResources().getString(R.string.resume));
            }
        });

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("1020D48579F1A64C9033B75B11010F23")
                .build();
        mAdView.loadAd(adRequest);
    }
}
