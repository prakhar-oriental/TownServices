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

public class VechileOptionAdapter extends RecyclerView.Adapter<VechileOptionAdapterViewHolder> {
    @NonNull
    ArrayList<VechileData> vechileData;
    Context context;

    public VechileOptionAdapter(@NonNull ArrayList<VechileData> vechileData, Context context) {
        this.vechileData = vechileData;
        this.context = context;
    }

    @Override
    public VechileOptionAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater vechilelayoutInflater = LayoutInflater.from(parent.getContext());
        View view = vechilelayoutInflater.inflate(R.layout.description,parent,false);
        VechileOptionAdapterViewHolder vechileOptionAdapterViewHolder = new VechileOptionAdapterViewHolder(view);
        return vechileOptionAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VechileOptionAdapterViewHolder holder, int position) {
        VechileData temp = vechileData.get(position);
        holder.vechilepersonimg.setImageResource(temp.getVechileimg());
        holder.vechilename.setText(temp.getVechilename());
        holder.vechilephoneNumber.setText(temp.getVechilephoneNumber());
        holder.vechileaddresslogo.setImageResource(temp.getVechileaddressimg());
        holder.vechilephoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:" + temp.getVechilephoneNumber());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callIntent);
            }
        });
        holder.vechileaddresslogo.setOnClickListener(new View.OnClickListener() {
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
        return vechileData.size();
    }
}
class VechileOptionAdapterViewHolder extends RecyclerView.ViewHolder {
    ImageView vechilepersonimg,vechileaddresslogo;
    TextView vechilename,vechilephoneNumber;

    public VechileOptionAdapterViewHolder(@NonNull View itemView) {
        super(itemView);
        vechilepersonimg = itemView.findViewById(R.id.personimg);
        vechileaddresslogo = itemView.findViewById(R.id.personAddress);
        vechilename = itemView.findViewById(R.id.personname);
        vechilephoneNumber = itemView.findViewById(R.id.personPN);
    }
}

