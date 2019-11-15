package com.example.catappv2;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {


    List<Cat> catsToAdapt = new ArrayList<>();

    public void setData(List<Cat> catsToAdapt){
        this.catsToAdapt = catsToAdapt;
    }

    @NonNull
    @Override

    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cat, parent, false);

        CatViewHolder catViewHolder = new CatViewHolder(view);
        return catViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position){
        final Cat catAtPosition = catsToAdapt.get(position);

        holder.nameTextView.setText(catAtPosition.getName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, CatDetailActivity.class);
                intent.putExtra("id", catAtPosition.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override

    public int getItemCount(){
        return catsToAdapt.size();
    }


    public static class CatViewHolder extends RecyclerView.ViewHolder{
        public View view;
        TextView nameTextView;

        public CatViewHolder(View view){
            super(view);
            this.view = view;
            nameTextView = view.findViewById(R.id.tv_name);

        }

}





}