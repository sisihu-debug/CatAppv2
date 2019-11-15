package com.example.catappv2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder> {

    List<String> catsToAdapt = new ArrayList<>();

    public void setData(List<String> catsToAdapt){
        this.catsToAdapt = catsToAdapt;
    }


    public FavAdapter.FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cat, parent, false);

        FavAdapter.FavViewHolder favViewHolder = new FavAdapter.FavViewHolder(view);
        return favViewHolder;
    }

    public void onBindViewHolder(@NonNull FavAdapter.FavViewHolder holder, int position) {
        final String catAtPosition = catsToAdapt.get(position);


        holder.nameTextView.setText(catAtPosition);



    }

    public int getItemCount(){
        return catsToAdapt.size();
    }


    public static class FavViewHolder extends RecyclerView.ViewHolder{
        public View view;
        TextView nameTextView;
//        ImageView photoImageView;



        public FavViewHolder(View view){
            super(view);
            this.view = view;
            nameTextView = view.findViewById(R.id.tv_name);
//            photoImageView = view.findViewById(R.id.iv_photo);


        }

    }

}
