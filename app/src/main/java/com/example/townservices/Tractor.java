package com.example.townservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Tractor extends AppCompatActivity {
    RecyclerView tractorrecyclerView;
    TractorOptionAdapter tractorOptionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tractor);

        tractorrecyclerView = findViewById(R.id.rcvTractor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        tractorrecyclerView.setLayoutManager(linearLayoutManager);
        tractorOptionAdapter = new TractorOptionAdapter(tractordata(),getApplicationContext());
        tractorrecyclerView.setAdapter(tractorOptionAdapter);
    }
    public ArrayList<TractorData> tractordata()
    {
        ArrayList<TractorData> tractorData = new ArrayList<>();
        TractorData tfirstpersona = new TractorData();
        tfirstpersona.setTractorimg(R.drawable.person);
        tfirstpersona.setTractorname("Ravi");
        tfirstpersona.setTractorphoneNumber("4083085072");
        tfirstpersona.setTractoraddressimg(R.drawable.location);
        tractorData.add(tfirstpersona);

        TractorData tfirstpersonb = new TractorData();
        tfirstpersonb.setTractorimg(R.drawable.person);
        tfirstpersonb.setTractorname("Ravi");
        tfirstpersonb.setTractorphoneNumber("4083085072");
        tfirstpersonb.setTractoraddressimg(R.drawable.location);
        tractorData.add(tfirstpersonb);

        TractorData tfirstpersonc = new TractorData();
        tfirstpersonc.setTractorimg(R.drawable.person);
        tfirstpersonc.setTractorname("Ravi");
        tfirstpersonc.setTractorphoneNumber("4083085072");
        tfirstpersonc.setTractoraddressimg(R.drawable.location);
        tractorData.add(tfirstpersonc);

        TractorData tfirstpersond = new TractorData();
        tfirstpersond.setTractorimg(R.drawable.person);
        tfirstpersond.setTractorname("Ravi");
        tfirstpersond.setTractorphoneNumber("4083085072");
        tfirstpersond.setTractoraddressimg(R.drawable.location);
        tractorData.add(tfirstpersond);

        TractorData tfirstpersone = new TractorData();
        tfirstpersone.setTractorimg(R.drawable.person);
        tfirstpersone.setTractorname("Ravi");
        tfirstpersone.setTractorphoneNumber("4083085072");
        tfirstpersone.setTractoraddressimg(R.drawable.location);
        tractorData.add(tfirstpersone);
        return tractorData;
    }
}