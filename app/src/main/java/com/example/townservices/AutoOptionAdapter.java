package com.example.townservices;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AutoOptionAdapter extends RecyclerView.Adapter<AutoOptionAdapterViewHolder> {
    @NonNull
    ArrayList<AutoData> autoData;
    Context context;

    public AutoOptionAdapter(@NonNull ArrayList<AutoData> autoData, Context context) {
        this.autoData = autoData;
        this.context = context;
    }

    @Override
    public AutoOptionAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater autolayoutInflater = LayoutInflater.from(parent.getContext());
        View view = autolayoutInflater.inflate(R.layout.description,parent,false);
        AutoOptionAdapterViewHolder autoOptionAdapterViewHolder = new AutoOptionAdapterViewHolder(view);
        return autoOptionAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AutoOptionAdapterViewHolder holder, int position) {
        AutoData temp = autoData.get(position);
        holder.personimg.setImageResource(temp.getAutoimg());
        holder.name.setText(temp.getName());
        holder.phoneNumber.setText(temp.getPhoneNumber());
        holder.addresslogo.setImageResource(temp.getAddressimg());
        holder.phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:" + temp.getPhoneNumber());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callIntent);
            }
        });
        holder.addresslogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    if(position==0 || position==1 || position==2 || position==3 || position==4)
                    {
                        //22.451370000885923, 77.46208128147137
                        //geo:23.2465° N, 77.5018° E
                        Uri gmmIntentUri = Uri.parse("google.navigation:q=22.451370000885923, 77.46208128147137");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        mapIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(mapIntent);
                    }

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return autoData.size();
    }
}
class AutoOptionAdapterViewHolder extends RecyclerView.ViewHolder {
    ImageView personimg,addresslogo;
    TextView name,phoneNumber;
    public AutoOptionAdapterViewHolder(@NonNull View itemView) {
        super(itemView);
        personimg = itemView.findViewById(R.id.personimg);
        addresslogo = itemView.findViewById(R.id.personAddress);
        name = itemView.findViewById(R.id.personname);
        phoneNumber = itemView.findViewById(R.id.personPN);
    }
}
