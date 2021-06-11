package com.example.townservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class vechile extends AppCompatActivity {
    RecyclerView vechilerecyclerView;
    VechileOptionAdapter vechileOptionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vechile);

        vechilerecyclerView = findViewById(R.id.rcvVechile);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        vechilerecyclerView.setLayoutManager(linearLayoutManager);
        vechileOptionAdapter = new VechileOptionAdapter(vechiledata(),getApplicationContext());
        vechilerecyclerView.setAdapter(vechileOptionAdapter);
    }
    public ArrayList<VechileData> vechiledata()
    {
        ArrayList<VechileData> vechileData = new ArrayList<>();
        VechileData vfirstpersona = new VechileData();
        vfirstpersona.setVechileimg(R.drawable.person);
        vfirstpersona.setVechilename("Ravi");
        vfirstpersona.setVechilephoneNumber("4083085072");
        vfirstpersona.setVechileaddressimg(R.drawable.location);
        vechileData.add(vfirstpersona);

        VechileData vfirstpersonb = new VechileData();
        vfirstpersonb.setVechileimg(R.drawable.person);
        vfirstpersonb.setVechilename("Ravi");
        vfirstpersonb.setVechilephoneNumber("4083085072");
        vfirstpersonb.setVechileaddressimg(R.drawable.location);
        vechileData.add(vfirstpersonb);

        VechileData vfirstpersonc = new VechileData();
        vfirstpersonc.setVechileimg(R.drawable.person);
        vfirstpersonc.setVechilename("Ravi");
        vfirstpersonc.setVechilephoneNumber("4083085072");
        vfirstpersonc.setVechileaddressimg(R.drawable.location);
        vechileData.add(vfirstpersonc);

        VechileData vfirstpersond = new VechileData();
        vfirstpersond.setVechileimg(R.drawable.person);
        vfirstpersond.setVechilename("Ravi");
        vfirstpersond.setVechilephoneNumber("4083085072");
        vfirstpersond.setVechileaddressimg(R.drawable.location);
        vechileData.add(vfirstpersond);

        VechileData vfirstpersone = new VechileData();
        vfirstpersone.setVechileimg(R.drawable.person);
        vfirstpersone.setVechilename("Ravi");
        vfirstpersone.setVechilephoneNumber("4083085072");
        vfirstpersone.setVechileaddressimg(R.drawable.location);
        vechileData.add(vfirstpersone);
       return vechileData;
    }
}