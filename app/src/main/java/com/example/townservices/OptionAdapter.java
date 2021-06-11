package com.example.townservices;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OptionAdapter extends RecyclerView.Adapter<OptionViewHolder> {

    @NonNull
    ArrayList<Data> data;
    Context context;

    public OptionAdapter(@NonNull ArrayList<Data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public OptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.serviesoption,parent,false);
        OptionViewHolder optionViewHolder = new OptionViewHolder(view);
        return optionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OptionViewHolder holder, int position) {
            Data temp = data.get(position);
           holder.serviceimg.setImageResource(data.get(position).getImage());
           holder.servicename.setText(data.get(position).getServicename());
       // Log.d("op", String.valueOf(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0)
                {
                    Intent intentauto = new Intent(context,Auto.class);
                    intentauto.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(intentauto);
                }else if(position==1)
                {
                    Intent intentVechile = new Intent(context,vechile.class);
                    intentVechile.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intentVechile);
                }else if(position==2)
                {
                    Intent intentTeactor = new Intent(context,Tractor.class);
                    intentTeactor.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intentTeactor);
                }else if(position==3)
                {
                    Intent intentPickup = new Intent(context,Pickup.class);
                    intentPickup.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intentPickup);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
class OptionViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    ImageView serviceimg;
    TextView servicename;
    public OptionViewHolder(@NonNull View itemView) {
        super(itemView);
         serviceimg= itemView.findViewById(R.id.serviceimg);
         servicename = itemView.findViewById(R.id.servicename);
         cardView = itemView.findViewById(R.id.cv);
    }
}
