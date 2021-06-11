package com.example.townservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

RecyclerView rcv;
OptionAdapter optionAdapter;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        setUpToolbar();

        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case  R.id.nav_home:

                        Intent intent = new Intent(Activity1.this, Activity1.class);
                        startActivity(intent);
                        break;
                    case R.id.aboutus:
                        Intent intent2 = new Intent(Activity1.this, Aboutus.class);
                        startActivity(intent2);
                        break;
                    case R.id.logout:
                        Intent intent3 = new Intent(Activity1.this, loginActivity2.class);
                        startActivity(intent3);
                        break;




                }
                return false;
            }
        });



        rcv = findViewById(R.id.rcv1);

        //ads();
        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rcv.setLayoutManager(gridLayoutManager);*/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
          rcv.setLayoutManager(linearLayoutManager);
        optionAdapter  = new OptionAdapter(datasend(),getApplicationContext());
        rcv.setAdapter(optionAdapter);
    }



  /*  private void ads() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                Toast.makeText(Activity1.this, ""+adError.getMessage(), Toast.LENGTH_SHORT).show();
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
    }*/

    public ArrayList<Data> datasend()
    {
        ArrayList<Data> holder = new ArrayList<>();
        Data a = new Data();
        a.setImage(R.drawable.riksa);
        a.setServicename("Auto Services");
        holder.add(a);

        Data b= new Data();
        b.setImage(R.drawable.vechile);
        b.setServicename("Vechile Services");
        holder.add(b);

        Data c = new Data();
        c.setImage(R.drawable.tracter);
        c.setServicename("Tractor Services");
        holder.add(c);

        Data d = new Data();
        d.setImage(R.drawable.pickup);
        d.setServicename("Pickup Services");
        holder.add(d);
        return holder;
    }
    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        //

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }
}