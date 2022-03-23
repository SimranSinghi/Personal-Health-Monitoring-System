package com.example.personalhealthmonitoringapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Model> mList;
    Context context;

    public MyAdapter(Context context,ArrayList<Model> mList){
        this.mList = mList;
        this.context = context;
    }
     @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent, false);
         return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = mList.get(position);
        holder.Dname.setText(model.getDname());
        holder.BP.setText(model.getBP());
        holder.HRate.setText(model.getHRate());
        holder.ResRate.setText(model.getResRate());
        holder.Date.setText(model.getDate());
        holder.Chol.setText(model.getCholesterol());
        holder.Btemp.setText(model.getBodyTemp());
        holder.Notes.setText(model.getNotes());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Dname,BP,HRate,ResRate,Date,Chol,Btemp,Notes;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Dname = itemView.findViewById(R.id.DN);
            BP = itemView.findViewById(R.id.bp);
            HRate = itemView.findViewById(R.id.hr);
            ResRate = itemView.findViewById(R.id.rr);
            Date = itemView.findViewById(R.id.itemDate);
            Btemp = itemView.findViewById(R.id.itemBT);
            Notes = itemView.findViewById(R.id.itemNotes);
            Chol = itemView.findViewById(R.id.itemCholesterol);



        }
    }
}
