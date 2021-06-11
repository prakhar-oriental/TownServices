package com.example.townservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Auto extends AppCompatActivity {
RecyclerView autorecyclerView;
AutoOptionAdapter autoOptionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        autorecyclerView = findViewById(R.id.rcvauto);
   LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
   autorecyclerView.setLayoutManager(linearLayoutManager);
   autoOptionAdapter = new AutoOptionAdapter(autodata(),getApplicationContext());
   autorecyclerView.setAdapter(autoOptionAdapter);

    }
    public ArrayList<AutoData> autodata()
    {
        ArrayList<AutoData> autoData = new ArrayList<>();
        AutoData firstpersona = new AutoData();
        firstpersona.setAutoimg(R.drawable.person);
        firstpersona.setName("Ravi");
        firstpersona.setPhoneNumber("4083085072");
        firstpersona.setAddressimg(R.drawable.location);
        autoData.add(firstpersona);

        AutoData firstpersonb = new AutoData();
        firstpersonb.setAutoimg(R.drawable.person);
        firstpersonb.setName("Mukesh");
        firstpersonb.setPhoneNumber("40857785072");
        firstpersonb.setAddressimg(R.drawable.location);
        autoData.add(firstpersonb);

        AutoData firstpersonc = new AutoData();
        firstpersonc.setAutoimg(R.drawable.person);
        firstpersonc.setName("Palavi");
        firstpersonc.setPhoneNumber("6574085072");
        firstpersonc.setAddressimg(R.drawable.location);
        autoData.add(firstpersonc);

        AutoData firstpersond = new AutoData();
        firstpersond.setAutoimg(R.drawable.person);
        firstpersond.setName("Shyam");
        firstpersond.setPhoneNumber("40836445072");
        firstpersond.setAddressimg(R.drawable.location);
        autoData.add(firstpersond);


        AutoData firstpersone = new AutoData();
        firstpersone.setAutoimg(R.drawable.person);
        firstpersone.setName("Vikas");
        firstpersone.setPhoneNumber("4083085072");
        firstpersone.setAddressimg(R.drawable.location);
        autoData.add(firstpersone);

        return autoData;
    }
}