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

public class TractorOptionAdapter extends RecyclerView.Adapter<TractorOptionViewHolder> {
    @NonNull
    ArrayList<TractorData> tractorData;
    Context context;

    public TractorOptionAdapter(@NonNull ArrayList<TractorData> tractorData, Context context) {
        this.tractorData = tractorData;
        this.context = context;
    }

    @Override
    public TractorOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater tractorlayoutInflater = LayoutInflater.from(parent.getContext());
        View view = tractorlayoutInflater.inflate(R.layout.description,parent,false);
        TractorOptionViewHolder tractorOptionViewHolder = new TractorOptionViewHolder(view);
        return tractorOptionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TractorOptionViewHolder holder, int position) {
        TractorData temp = tractorData.get(position);
        holder.tractorpersonimg.setImageResource(temp.getTractorimg());
        holder.tractorname.setText(temp.getTractorname());
        holder.tractorphoneNumber.setText(temp.getTractorphoneNumber());
        holder.tractoraddresslogo.setImageResource(temp.getTractoraddressimg());
        holder.tractorphoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:" + temp.getTractorphoneNumber());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callIntent);
            }
        });
        holder.tractoraddresslogo.setOnClickListener(new View.OnClickListener() {
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
        return  tractorData.size();
    }
}
class TractorOptionViewHolder extends RecyclerView.ViewHolder {
    ImageView tractorpersonimg,tractoraddresslogo;
    TextView tractorname,tractorphoneNumber;
    public TractorOptionViewHolder(@NonNull View itemView) {
        super(itemView);
        tractorpersonimg = itemView.findViewById(R.id.personimg);
        tractoraddresslogo = itemView.findViewById(R.id.personAddress);
        tractorname = itemView.findViewById(R.id.personname);
        tractorphoneNumber = itemView.findViewById(R.id.personPN);
    }
}

