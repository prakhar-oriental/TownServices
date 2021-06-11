package com.example.townservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Pickup extends AppCompatActivity {
    RecyclerView pickuprecyclerView;
    PickupOptionAdapter pickupOptionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);

        pickuprecyclerView = findViewById(R.id.rcvPickup);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        pickuprecyclerView.setLayoutManager(linearLayoutManager);
        pickupOptionAdapter = new PickupOptionAdapter(pickupdata(),getApplicationContext());
        pickuprecyclerView.setAdapter(pickupOptionAdapter);
    }
    public ArrayList<PickupData> pickupdata()
    {
        ArrayList<PickupData> pickupData = new ArrayList<>();
        PickupData pfirstpersona = new PickupData();
        pfirstpersona.setPickupimg(R.drawable.person);
        pfirstpersona.setPickupname("Ravi");
        pfirstpersona.setPickupphoneNumber("4083085072");
        pfirstpersona.setPickupaddressimg(R.drawable.location);
        pickupData.add(pfirstpersona);

        PickupData pfirstpersonb = new PickupData();
        pfirstpersonb.setPickupimg(R.drawable.person);
        pfirstpersonb.setPickupname("Ravi");
        pfirstpersonb.setPickupphoneNumber("4083085072");
        pfirstpersonb.setPickupaddressimg(R.drawable.location);
        pickupData.add(pfirstpersonb);

        PickupData pfirstpersonc = new PickupData();
        pfirstpersonc.setPickupimg(R.drawable.person);
        pfirstpersonc.setPickupname("Ravi");
        pfirstpersonc.setPickupphoneNumber("4083085072");
        pfirstpersonc.setPickupaddressimg(R.drawable.location);
        pickupData.add(pfirstpersonc);

        PickupData pfirstpersond = new PickupData();
        pfirstpersond.setPickupimg(R.drawable.person);
        pfirstpersond.setPickupname("Ravi");
        pfirstpersond.setPickupphoneNumber("4083085072");
        pfirstpersond.setPickupaddressimg(R.drawable.location);
        pickupData.add(pfirstpersond);

        PickupData pfirstpersone = new PickupData();
        pfirstpersone.setPickupimg(R.drawable.person);
        pfirstpersone.setPickupname("Ravi");
        pfirstpersone.setPickupphoneNumber("4083085072");
        pfirstpersone.setPickupaddressimg(R.drawable.location);
        pickupData.add(pfirstpersone);

        return pickupData;
    }
}