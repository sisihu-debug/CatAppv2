package com.example.catappv2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.ExtractedTextRequest;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
import com.example.catappv2.Cat;

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



//        holder.view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Context context = view.getContext();
//
//                Intent intent = new Intent(context, CatDetailActivity.class);
//                intent.putExtra("ArticleID", catAtPosition.getId());
//                context.startActivity(intent);
//            }
//        });

//        holder.shareImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Context context = view.getContext();
//                Intent intent = new Intent(Intent.ACTION_SEND);
//
//                intent.putExtra(Intent.EXTRA_TEXT, articleAtPosition.getTitle());
//                intent.setType("text/plain");
//                context.startActivity(intent);
//            }
//        });

//        if (catAtPosition.getMedia() != null) {
//            String imageUrl = articleAtPosition.getMedia()[0].getMedia_metadata()[0].getUrl();
//            Glide.with(holder.view.getContext()).load(imageUrl).into(holder.articleImageView);
//        }
    }

    @Override

    public int getItemCount(){
        return catsToAdapt.size();
    }


    public static class CatViewHolder extends RecyclerView.ViewHolder{
        public View view;
        TextView nameTextView;
        ImageView photoImageView;



        public CatViewHolder(View view){
            super(view);
            this.view = view;
            nameTextView = view.findViewById(R.id.tv_name);
            photoImageView = view.findViewById(R.id.iv_photo);




        }

}





}