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

public class PickupOptionAdapter extends RecyclerView.Adapter<PickupOptionViewHolder> {
    @NonNull
    ArrayList<PickupData> pickupData;
    Context context;

    public PickupOptionAdapter(@NonNull ArrayList<PickupData> pickupData, Context context) {
        this.pickupData = pickupData;
        this.context = context;
    }

    @Override
    public PickupOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater pickuplayoutInflater = LayoutInflater.from(parent.getContext());
        View view = pickuplayoutInflater.inflate(R.layout.description,parent,false);
        PickupOptionViewHolder pickupOptionViewHolder = new PickupOptionViewHolder(view);
        return pickupOptionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PickupOptionViewHolder holder, int position) {
        PickupData temp = pickupData.get(position);
        holder.pickuppersonimg.setImageResource(temp.getPickupimg());
        holder.pickupname.setText(temp.getPickupname());
        holder.pickupphoneNumber.setText(temp.getPickupphoneNumber());
        holder.pickupaddresslogo.setImageResource(temp.getPickupaddressimg());
        holder.pickupphoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:" + temp.getPickupphoneNumber());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callIntent);
            }
        });
        holder.pickupaddresslogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
    }

    @Override
    public int getItemCount() {
        return pickupData.size();
    }
}
class  PickupOptionViewHolder extends RecyclerView.ViewHolder {
    ImageView pickuppersonimg,pickupaddresslogo;
    TextView pickupname,pickupphoneNumber;
    public PickupOptionViewHolder(@NonNull View itemView) {
        super(itemView);
        pickuppersonimg = itemView.findViewById(R.id.personimg);
        pickupaddresslogo = itemView.findViewById(R.id.personAddress);
        pickupname = itemView.findViewById(R.id.personname);
        pickupphoneNumber = itemView.findViewById(R.id.personPN);
    }
}
